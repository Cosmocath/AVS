package service.produitVendu.impl;

import persistance.produitVendu.beanDo.ProduitVenduDo;
import presentation.produit.beanDto.ProduitDto;

/**
 * @author Guy-Joël
 *
 */
public class ProduitVenduService {

    private ProduitVenduService() {
        //Empty Constructeur
    }

    /**
     * permet de mapper un produitDto en produitVenduDo
     * 
     * @param produitDto
     * @return produitVenduDo
     */
    ProduitVenduDo mapProduitDtoToProduitVenduDo(final ProduitDto produitDto) {
        final ProduitVenduDo produitVenduDo = new ProduitVenduDo();
        produitVenduDo.setIdProduitHistorise(produitDto.getId());
        produitVenduDo.setDesignation(produitDto.getDesignation());
        produitVenduDo.setReference(produitDto.getReference());
        produitVenduDo.setDescription(produitDto.getDescription());
        produitVenduDo.setPrix(Double.parseDouble(produitDto.getPrix()));
        produitVenduDo.setImage(produitDto.getImage());
        produitVenduDo.setNumeroVersion(produitDto.getNoVersion());
        return produitVenduDo;

    }
}
