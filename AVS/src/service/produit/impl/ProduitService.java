/**
 * 
 */
package service.produit.impl;

import java.util.List;

import persistance.produit.beanDo.ProduitDo;
import persistance.produit.dao.IProduitDao;
import presentation.produit.beanDto.ProduitDto;
import service.produit.IProduitService;
import service.produit.ProduitMapper;
import util.Factory;
import util.OrderBy;

/**
 * @author Nora Liferki
 *
 */
public class ProduitService implements IProduitService {

    private final IProduitDao iProduitDao = Factory.getInstance(IProduitDao.class);

    // SINGLETON QUI COMPREND UNIQUEMENT UN CONSTRUCTEUR Private => plus besoin de l'instance et du getInstance grâce à la factory de XSI

    /**
     * Constructeur
     * 
     */
    private ProduitService() {
        // empty constructor
    }

    @Override
    public List<ProduitDto> findAllProduitOrderBy(final OrderBy orderBy) {

        final List<ProduitDo> listeProduitDo = iProduitDao.findAllProduitOrderBy(orderBy);
        return ProduitMapper.mapToListDto(listeProduitDo);
    }
}
