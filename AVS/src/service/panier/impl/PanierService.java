package service.panier.impl;

import presentation.panier.beanDto.PanierDto;
import presentation.produit.beanDto.ProduitDto;
import service.panier.IPanierService;
import service.produit.IProduitService;
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
        if (panierDto.getQuantiteTotale() > QUANTITE_AVANT_REMISE && totalAvtRemise >= SEUIL_REMISE) {
            // on calcule le total après la remise
            panierDto.setTotalApresRemise(FormatUtil.convertirDoubleToString(totalAvtRemise * REMISE));
            // on calcule la remise
            final double totalApresRemise = FormatUtil.convertirStringToDouble(panierDto.getTotalApresRemise());
            panierDto.setRemise(FormatUtil.convertirDoubleToString(totalAvtRemise - totalApresRemise));
            return panierDto;
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
