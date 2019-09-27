package service.panier.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import persistance.commande.beanDo.CommandeDo;
import persistance.commande.beanDo.CommandeProduitDo;
import persistance.commande.dao.ICommandeDao;
import persistance.produitVendu.beanDo.ProduitVenduDo;
import presentation.panier.beanDto.CommandeInfoDto;
import presentation.panier.beanDto.PanierDto;
import presentation.produit.beanDto.ProduitDto;
import service.panier.IPanierService;
import service.produit.IProduitService;
import service.produitVendu.IProduitVenduService;
import service.users.IUserService;
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
     * V�rifie que tous les produits du panier sont � jour avec la table 'Produit' en terme de version
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
        final CommandeDo commandeDo = new CommandeDo();
        commandeDo.setAdresseLivraison(commandeInfoDto.getAdresseLivraison());
        commandeDo.setAdresseFacturation(commandeInfoDto.getAdresseFacturation());
        
        // r�cup�ration de l'idUser
        final int idUser = Integer.valueOf(commandeInfoDto.getUserId());
        commandeDo.setIdUtilisateur(idUser);

        //TODO RKU : d�finir N�commande (pour l'instant en dur)
        commandeDo.setNumeroCommande("007_numero en dur");
        //renseignement du nom
        final IUserService iUserService = Factory.getInstance(IUserService.class);
        //on recup�re le nom de l'utilisateur
        final String nomUtilisateur = iUserService.findUserDto(idUser).getNom();
        commandeDo.setNom(nomUtilisateur);

        commandeDo.setDateCommande(new Date());
        commandeDo.setMontantSansRemise(FormatUtil.convertirStringToDouble(panierDto.getTotalAvantRemise()));
        commandeDo.setRemise(FormatUtil.convertirStringToDouble(panierDto.getRemise()));

        // construction du Set CommandeProduitDo
        final Set<CommandeProduitDo> setCommandeProduitDo = new HashSet<>();
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

        // on met � jour la map
        // on r�cup�re la quantit� et le prix pour 1 produit dans le panier
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
            // on met � jour la map en ajoutant 1 � la quantit� et le nouveau prix en String
            panierDto.getMapDesProduitsQte().put(produitDto, quantitePrix.ajouterQuantite(1).updatePrix(FormatUtil.convertirDoubleToString(prixTotal)));
        }

        // on met � jour les autres attributs du panier
        panierDto.setQuantiteTotale(panierDto.getMapDesProduitsQte().size());
        // on convertit pour les calculs
        final double total = FormatUtil.convertirStringToDouble(produitDto.getPrix());
        final double totalAvtRemise = FormatUtil.convertirStringToDouble(panierDto.getTotalAvantRemise());
        // on met � jour
        panierDto.setTotalAvantRemise(FormatUtil.convertirDoubleToString(totalAvtRemise + total));
        // on calcule la remise
        remisePanier(panierDto);

        return panierDto;
    }

    @Override
    public PanierDto diminuerProduitPanier(final PanierDto panierDto, final int idProduit) {
        final IProduitService iProduitService = Factory.getInstance(IProduitService.class);
        final ProduitDto produitDto = iProduitService.getProduitById(idProduit);

        // on r�cup�re la quantit� du produit dans le panier
        final PanierDto.QuantitePrix quantitePrix = panierDto.getMapDesProduitsQte().get(produitDto);
        final Integer quantite = quantitePrix.getQuantite();
        if (quantite == 1) {
            // s'il n'y a qu'un produit dans le panier, on enleve le produit de la map
            panierDto.getMapDesProduitsQte().remove(produitDto);
        } else {
            // on convertit en double pour faire les calculs
            final double prixProduit = FormatUtil.convertirStringToDouble(produitDto.getPrix());
            final double prixCourant = FormatUtil.convertirStringToDouble(quantitePrix.getPrixParProduit());
            // on calcule le nouveau prix
            final double prixTotal = prixCourant - prixProduit;
            // on met � jour la map en ajoutant 1 � la quantit� et le nouveau prix en String
            panierDto.getMapDesProduitsQte().put(produitDto, quantitePrix.ajouterQuantite(-1).updatePrix(FormatUtil.convertirDoubleToString(prixTotal)));
        }

        // on met � jour les autres attributs du panier
        panierDto.setQuantiteTotale(panierDto.getMapDesProduitsQte().size());
        // on convertit pour les calculs
        final double total = FormatUtil.convertirStringToDouble(produitDto.getPrix());
        final double totalAvtRemise = FormatUtil.convertirStringToDouble(panierDto.getTotalAvantRemise());
        // on met � jour
        panierDto.setTotalAvantRemise(FormatUtil.convertirDoubleToString(totalAvtRemise - total));
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
            // on calcule le total apr�s la remise
            panierDto.setTotalApresRemise(FormatUtil.convertirDoubleToString(totalAvtRemise * REMISE));
            // on calcule la remise
            totalApresRemise = FormatUtil.convertirStringToDouble(panierDto.getTotalApresRemise());
            panierDto.setRemise(FormatUtil.convertirDoubleToString(totalAvtRemise - totalApresRemise));
            return panierDto;
        } else {
            panierDto.setRemise(FormatUtil.convertirDoubleToString(0.00));
            // on calcule le total apr�s la remise
            panierDto.setTotalApresRemise(FormatUtil.convertirDoubleToString(totalAvtRemise));
        }

        return panierDto;
    }

    @Override

    public PanierDto deleteProduitPanier(final PanierDto panierDto, final int idProduit) {
        final IProduitService iProduitService = Factory.getInstance(IProduitService.class);

        // R�cup�ration de du produit gr�ce � son Id
        final ProduitDto produitDto = iProduitService.getProduitById(idProduit);

        //R�cup�ration "Quantit�Prix" dans la map 
        final PanierDto.QuantitePrix quantitePrix = panierDto.getMapDesProduitsQte().get(produitDto);

        //R�cup�ration de la quantit� de produit dans "Quantit�Prix (classe)" 
        final int quantite = quantitePrix.getQuantite();

        //Suppression du produit de la map
        panierDto.getMapDesProduitsQte().remove(produitDto, quantitePrix);

        // Je m�j la quantiteTotale 
        panierDto.setQuantiteTotale(panierDto.getMapDesProduitsQte().size());

        // D�duction du produit (quantit�*prix) du TotalAVantRemise
        final double totalAvtRemise = FormatUtil.convertirStringToDouble(panierDto.getTotalAvantRemise());
        final double total = FormatUtil.convertirStringToDouble(produitDto.getPrix()) * quantite;

        panierDto.setTotalAvantRemise(FormatUtil.convertirDoubleToString(totalAvtRemise - total));

        // on calcule la remise
        remisePanier(panierDto);
        return panierDto;
    }

    public CommandeDo validerPanier(PanierDto panierDto, CommandeInfoDto commandeInfoDto) {

        // v�rifier que les produits sont bien � jour
        if (!isPanierValidable(panierDto)) {
            return null;
        }

        // construction de la map ProduitVenduDo/Quantit�
        final IProduitVenduService iProduitVenduService = Factory.getInstance(IProduitVenduService.class);
        final Map<ProduitVenduDo, Integer> mapProduitVenduQuantite = iProduitVenduService.buildMapProduitVenduQuantite(panierDto);
        // TODO RKU
        System.out.println("map taille" + mapProduitVenduQuantite);
        // construction de la commandeDo
        final CommandeDo commandeDo = buildCommandeDo(panierDto, commandeInfoDto, mapProduitVenduQuantite);
        // TODO RKU : g�rer nom
        commandeDo.setNom("commandeTest");
        commandeDo.setNumeroCommande("2001");
        // persistance
        final ICommandeDao iCommandeDao = Factory.getInstance(ICommandeDao.class);
        return iCommandeDao.createCommandeDo(commandeDo);
        
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
