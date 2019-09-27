package service.produitVendu.impl;

import persistance.produitVendu.beanDo.ProduitVenduDo;
import presentation.produit.beanDto.ProduitDto;
import presentation.produitVendu.beanDto.ProduitVenduDto;
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

    @Override
    public ProduitVenduDto mapProduitDoToDto(final ProduitVenduDo produitVenduDo) {
        final ProduitVenduDto produitVenduDto = new ProduitVenduDto();
        produitVenduDto.setIdProduitHistorise(produitVenduDo.getIdProduitHistorise());
        produitVenduDto.setReference(produitVenduDo.getReference());
        produitVenduDto.setPrix(FormatUtil.convertirDoubleToString(produitVenduDo.getPrix()));
        produitVenduDto.setImage(produitVenduDo.getImage());
        return produitVenduDto;
    }
}
