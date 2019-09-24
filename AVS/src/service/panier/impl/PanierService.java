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

    private PanierService() {
        //Empty Constructeur
    }

    @Override
    public PanierDto addProduitPanier(final PanierDto panierDto, final int idProduit) {

        final IProduitService iProduitService = Factory.getInstance(IProduitService.class);
        final ProduitDto produitDto = iProduitService.getProduitById(idProduit);
        if (produitDto == null) {
            panierDto.getMapDesProduitsQte().put(produitDto, 1);
            panierDto.setQuantiteTotale(panierDto.getQuantiteTotale()+ 1);
        }
        panierDto.getMapDesProduitsQte().values().add(1);
        panierDto.setTotalAvantRemise(panierDto.getTotalAvantRemise() + produitDto.getPrix());

        return panierDto;
    }
}
