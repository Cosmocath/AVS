/**
 * 
 */
package service.produit.impl;

import java.util.ArrayList;
import java.util.List;

import persistance.produit.beanDo.ProduitDo;
import persistance.produit.dao.IProduitDao;
import presentation.produit.beanDto.ProduitDto;
import service.produit.IProduitService;
import util.Factory;

/**
 * @author Nora Liferki
 *
 */
public class ProduitService {

    private final IProduitDao      iProduitDao = Factory.getInstance(IProduitDao.class);

    // SINGLETON QUI COMPREND: UNE INSTANCE / UN CONSTRUCTEUR Private / GETiNSTANCE

    // Instanciation d'une Instance IProduitService
    private static IProduitService INSTANCE    = null;

    /**
     * Constructeur
     * 
     */
    private ProduitService() {
        // empty method
    }

    // On map une liste de produitDo en une liste de produitDto
    /**
     * On map une liste de produitDo en une liste de produitDto
     * 
     * @param listeProduitDo
     * @return une liste de produitDto
     */
    private List<ProduitDto> mapToListProduitDto(final List<ProduitDo> listeProduitDo) {
        final List<ProduitDto> listeProduitDto = new ArrayList<>();

        for (final ProduitDo produitDo : listeProduitDo) {
            listeProduitDto.add(mapToProduitDo(produitDo));
        }
        return listeProduitDto;
    }

    // On map un produitDo en produitDto
    /**
     * On map un produitDo en produitDto
     * 
     * @param ProduitDo
     * @return ProduitDto
     */
    private ProduitDto mapToProduitDo(final ProduitDo produitDo) {
        final ProduitDto produitDto = new ProduitDto();
        produitDto.setId(produitDo.getId());
        produitDto.setDescription(produitDo.getDescription());
        return produitDto;
    }
}
