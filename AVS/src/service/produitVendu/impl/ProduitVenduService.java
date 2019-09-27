package service.produitVendu.impl;

import persistance.produitVendu.beanDo.ProduitVenduDo;
import presentation.produit.beanDto.ProduitDto;
import service.produitVendu.IProduitVenduService;
import util.tools.FormatUtil;

/**
 * @author Rodolphe
 *
 */
public class ProduitVenduService implements IProduitVenduService {
    

    /**
     * Constructeur vide
     */
    private ProduitVenduService() {
        // Empty method
    }

    @Override
    public ProduitVenduDo mapProduitDtoToProduitVenduDo(ProduitDto produitDto) {
        final ProduitVenduDo produitVenduDo = new ProduitVenduDo();
        produitVenduDo.setIdProduitHistorise(produitDto.getId());
        produitVenduDo.setDesignation(produitDto.getDesignation());
        produitVenduDo.setReference(produitDto.getReference());
        produitVenduDo.setDescription(produitDto.getDescription());
        produitVenduDo.setPrix(FormatUtil.convertirStringToDouble(produitDto.getPrix()));
        produitVenduDo.setImage(produitDto.getImage());
        produitVenduDo.setNumeroVersion(produitDto.getNoVersion());
        return produitVenduDo;

    }
}
