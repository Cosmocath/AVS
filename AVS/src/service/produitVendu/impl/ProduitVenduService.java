package service.produitVendu.impl;

import java.util.HashMap;
import java.util.Map;

import persistance.produitVendu.beanDo.ProduitVenduDo;
import persistance.produitVendu.dao.IProduitVenduDao;
import presentation.panier.beanDto.PanierDto;
import presentation.panier.beanDto.PanierDto.QuantitePrix;
import presentation.produit.beanDto.ProduitDto;
import service.produitVendu.IProduitVenduService;
import util.factory.Factory;
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
    public ProduitVenduDo mapProduitDtoToProduitVenduDo(final ProduitDto produitDto) {
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
    public Map<ProduitVenduDo, Integer> buildMapProduitVenduQuantite(final PanierDto panierDto) {
        final Map<ProduitVenduDo, Integer> mapProduitVenduQuantite = new HashMap<>();
        final IProduitVenduDao iProduitVenduDao = Factory.getInstance(IProduitVenduDao.class);
        for (final Map.Entry<ProduitDto, QuantitePrix> entry : panierDto.getMapDesProduitsQte().entrySet()) {
            final ProduitDto produitDto = entry.getKey();
            // recherche d'un produitVendu correspondant à notre produit courant
            ProduitVenduDo produitVenduDo = iProduitVenduDao.findProduitVenduByIdProduitHistoriseAndVersion(produitDto.getId(), produitDto.getNoVersion());
            if (produitVenduDo == null) {
                // Mapping
                produitVenduDo = mapProduitDtoToProduitVenduDo(produitDto);
            }
            QuantitePrix quantitePrix = entry.getValue();
            mapProduitVenduQuantite.put(produitVenduDo, quantitePrix.getQuantite());
        }
        return mapProduitVenduQuantite;
    }

}
