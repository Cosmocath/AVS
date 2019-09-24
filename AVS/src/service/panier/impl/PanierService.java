package service.panier.impl;

import presentation.panier.beanDto.PanierDto;
import presentation.produit.beanDto.ProduitDto;
import service.panier.IPanierService;
import service.produit.IProduitService;
import util.factory.Factory;

/**
 * @author Nora LIFERKI
 *
 */
public class PanierService implements IPanierService {
    private static final double REMISE                = 0.9;
    private static final double QUANTITE_AVANT_REMISE = 5.0;
    private static final double SEUIL_REMISE          = 100.0;

    private PanierService() {
        //Empty Constructeur
    }

    @Override
    public PanierDto addProduitPanier(final PanierDto panierDto, final int idProduit) {

        final IProduitService iProduitService = Factory.getInstance(IProduitService.class);
        final ProduitDto produitDto = iProduitService.getProduitById(idProduit);
        if (produitDto == null) {
            panierDto.getMapDesProduitsQte().put(produitDto, 1);
            panierDto.setQuantiteTotale(panierDto.getQuantiteTotale() + 1);
        }
        panierDto.getMapDesProduitsQte().values().add(1);
        panierDto.setTotalAvantRemise(panierDto.getTotalAvantRemise() + produitDto.getPrix());

        return panierDto;
    }

    @Override
    public PanierDto remisePanier(final PanierDto panierDto) {
        if (panierDto.getQuantiteTotale() > QUANTITE_AVANT_REMISE && panierDto.getTotalAvantRemise() >= SEUIL_REMISE) {
            panierDto.setTotalApresRemise(panierDto.getTotalAvantRemise() * REMISE);
            return panierDto;
        }

        return panierDto;
    }
}
