package service.panier.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import persistance.commande.beanDo.CommandeDo;
import persistance.commande.beanDo.CommandeProduitDo;
import persistance.produitVendu.beanDo.ProduitVenduDo;
import presentation.panier.beanDto.CommandeInfoDto;
import presentation.panier.beanDto.PanierDto;
import presentation.produit.beanDto.ProduitDto;
import service.panier.IPanierService;
import service.produit.IProduitService;
import service.produitVendu.IProduitVenduService;
import util.factory.Factory;
import util.tools.FormatUtil;

/**
 * @author Nora LIFERKI
 *
 */
public class PanierService implements IPanierService {
    private static final double  REMISE                = 0.9;
    private static final Integer QUANTITE_AVANT_REMISE = 5;
    private static final double  SEUIL_REMISE          = 100.0;

    private PanierService() {
        //Empty Constructeur
    }

    /**
     * Vérifie que tous les produits du panier sont à jour avec la table 'Produit' (concerne les versions)
     * 
     * @param panierDto
     * @return vrai ou faux
     */
    private boolean isPanierValidable(final PanierDto panierDto) {
        final IProduitService iProduitService = Factory.getInstance(IProduitService.class);
        final Set<ProduitDto> setProduit = panierDto.getMapDesProduitsQte().keySet();
        for (final ProduitDto produitDto : setProduit) {
            if (!iProduitService.isProduitFromPanierUpToDate(produitDto.getId(), produitDto.getNoVersion())) {
                return false;
            }
        }
        return true;
    }

    private CommandeDo buildCommandeDo(final PanierDto panierDto, final CommandeInfoDto commandeInfoDto, final Map<ProduitVenduDo, Integer> mapProduitVenduQuantite) {
        CommandeDo commandeDo = new CommandeDo();
        commandeDo.setAdresseLivraison(commandeInfoDto.getAdresseLivraison());
        commandeDo.setAdresseFacturation(commandeInfoDto.getAdresseFacturation());

        commandeDo.setIdUtilisateur(Integer.valueOf(commandeInfoDto.getUserId()));

        //TODO RKU : définir nomUser, date et N°commande
        commandeDo.setMontantSansRemise(FormatUtil.convertirStringToDouble(panierDto.getTotalAvantRemise()));
        commandeDo.setRemise(FormatUtil.convertirStringToDouble(panierDto.getRemise()));

        // construction du Set CommandeProduitDo
        Set<CommandeProduitDo> setCommandeProduitDo = new HashSet<>();
        for (final Map.Entry<ProduitVenduDo, Integer> entry : mapProduitVenduQuantite.entrySet()) {
            final CommandeProduitDo commandeProduitDo = new CommandeProduitDo();
            commandeProduitDo.setCommandeDo(commandeDo);
            commandeProduitDo.setProduitVenduDo(entry.getKey());
            commandeProduitDo.setQuantite(entry.getValue());
            setCommandeProduitDo.add(commandeProduitDo);
        }
        commandeDo.setCommandeProduitSet(setCommandeProduitDo);
        return commandeDo;
    }

    @Override
    public PanierDto addProduitPanier(final PanierDto panierDto, final int idProduit) {
        final IProduitService iProduitService = Factory.getInstance(IProduitService.class);
        final ProduitDto produitDto = iProduitService.getProduitById(idProduit);

        // on met à jour la map
        // on récupère la quantité et le prix pour 1 produit dans le panier
        PanierDto.QuantitePrix quantitePrix = panierDto.getMapDesProduitsQte().get(produitDto);
        if (quantitePrix == null) {
            // le produit n'est pas dans le panier
            quantitePrix = new PanierDto.QuantitePrix().ajouterQuantite(1).updatePrix(produitDto.getPrix());
            panierDto.getMapDesProduitsQte().put(produitDto, quantitePrix);
        } else {
            // on convertit en double pour faire les calculs
            final double prixProduit = FormatUtil.convertirStringToDouble(produitDto.getPrix());
            final double prixCourant = FormatUtil.convertirStringToDouble(quantitePrix.getPrixParProduit());
            // on calcule le nouveau prix
            final double prixTotal = prixCourant + prixProduit;
            // on met à jour la map en ajoutant 1 à la quantité et le nouveau prix en String
            panierDto.getMapDesProduitsQte().put(produitDto, quantitePrix.ajouterQuantite(1).updatePrix(FormatUtil.convertirDoubleToString(prixTotal)));
        }

        // on met à jour les autres attributs du panier
        panierDto.setQuantiteTotale(panierDto.getMapDesProduitsQte().size());
        // on convertit pour les calculs
        final double total = FormatUtil.convertirStringToDouble(produitDto.getPrix());
        final double totalAvtRemise = FormatUtil.convertirStringToDouble(panierDto.getTotalAvantRemise());
        // on met à jour
        panierDto.setTotalAvantRemise(FormatUtil.convertirDoubleToString(totalAvtRemise + total));
        // on calcule la remise
        remisePanier(panierDto);

        return panierDto;
    }

    @Override
    public PanierDto remisePanier(final PanierDto panierDto) {
        // on convertit
        final double totalAvtRemise = FormatUtil.convertirStringToDouble(panierDto.getTotalAvantRemise());
        double totalApresRemise = 0;
        if (panierDto.getQuantiteTotale() > QUANTITE_AVANT_REMISE && totalAvtRemise >= SEUIL_REMISE) {
            // on calcule le total après la remise
            panierDto.setTotalApresRemise(FormatUtil.convertirDoubleToString(totalAvtRemise * REMISE));
            // on calcule la remise
            totalApresRemise = FormatUtil.convertirStringToDouble(panierDto.getTotalApresRemise());
            panierDto.setRemise(FormatUtil.convertirDoubleToString(totalAvtRemise - totalApresRemise));
            return panierDto;
        } else {
            panierDto.setRemise(FormatUtil.convertirDoubleToString(0.00));
            totalApresRemise = totalAvtRemise;
        }

        return panierDto;
    }

    @Override

    public PanierDto deleteProduitPanier(final PanierDto panierDto, final int idProduit) {
        final IProduitService iProduitService = Factory.getInstance(IProduitService.class);

        // Récupération de du produit grâce à son Id
        final ProduitDto produitDto = iProduitService.getProduitById(idProduit);

        //Récupération "QuantitéPrix" dans la map 
        final PanierDto.QuantitePrix quantitePrix = panierDto.getMapDesProduitsQte().get(produitDto);

        //Récupération de la quantité de produit dans "QuantitéPrix (classe)" 
        final int quantite = quantitePrix.getQuantite();

        //Suppression du produit de la map
        panierDto.getMapDesProduitsQte().remove(produitDto, quantitePrix);

        // Je màj la quantiteTotale 
        panierDto.setQuantiteTotale(panierDto.getMapDesProduitsQte().size());

        // Déduction du produit (quantité*prix) du TotalAVantRemise
        final double totalAvtRemise = FormatUtil.convertirStringToDouble(panierDto.getTotalAvantRemise());
        final double total = FormatUtil.convertirStringToDouble(produitDto.getPrix()) * quantite;

        panierDto.setTotalAvantRemise(FormatUtil.convertirDoubleToString(totalAvtRemise - total));

        // on calcule la remise
        remisePanier(panierDto);
        return panierDto;
    }

    public CommandeDo validerPanier(PanierDto panierDto, CommandeInfoDto commandeInfoDto) {

        // vérifier que les produits sont bien à jour
        if (!isPanierValidable(panierDto)) {
            // TODO RKU
            System.out.println("pdts pas a jour");
            return null;
        }

        // construction de la map ProduitVenduDo/Quantité
        final IProduitVenduService iProduitVenduService = Factory.getInstance(IProduitVenduService.class);
        final Map<ProduitVenduDo, Integer> mapProduitVenduQuantite = iProduitVenduService.buildMapProduitVenduQuantite(panierDto);
        // TODO RKU
        System.out.println("map taille" + mapProduitVenduQuantite);
        // construction de la commandeDo
        return buildCommandeDo(panierDto, commandeInfoDto, mapProduitVenduQuantite);

        // on parcourt les produits du panier
        for (final ProduitDto produitDto : setProduit) {
            // recherche d'un produitVendu correspondant à notre produit courant
            ProduitVenduDo produitVenduDo = iProduitVenduDao.findProduitVenduByIdProduitHistoriseAndVersion(produitDto.getId(), produitDto.getNoVersion());
            if (produitVenduDo == null) {
                // Mapping
                produitVenduDo = iProduitVenduService.mapProduitDtoToProduitVenduDo(produitDto);
            }
            CommandeProduitDo commandeProduitDo = new CommandeProduitDo();
            commandeProduitDo.setProduitVenduDo(produitVenduDo);
            // recherche quantité
            QuantitePrix quantitePrix = panierDto.getMapDesProduitsQte().get(produitDto);
            commandeProduitDo.setQuantite(quantitePrix.getQuantite());
            commandeDo.getCommandeProduitSet().add(commandeProduitDo);
        }
        return commandeDo;
    }

    @Override
    public PanierDto viderPanierDto(final PanierDto panierDto) {
        panierDto.setQuantiteTotale(0);
        panierDto.setTotalAvantRemise("0,00");
        panierDto.setRemise("0,00");
        panierDto.setTotalApresRemise("0,00");
        panierDto.getMapDesProduitsQte().clear();
        return panierDto;
    }
}
