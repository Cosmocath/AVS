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
        panierDto.getMapDesProduitsQte().put(produitDto, panierDto.getQuantiteTotale());
        panierDto.setTotalAvantRemise(produitDto.getPrix());
        //panierDto.setRemise();
        //panierDto.setTotalApresRemise();
        return panierDto;
    }
}
