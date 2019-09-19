package service.produit.impl;

import java.util.List;

import persistance.produit.beanDo.ProduitDo;
import persistance.produit.dao.IProduitDao;
import presentation.produit.beanDto.ProduitDto;
import service.produit.IProduitService;
import service.produit.ProduitMapper;
import util.enumeration.OrderBy;
import util.factory.Factory;

/**
 * Implémentation du service pour gérer les produits
 * 
 * @author Nora Liferki
 *
 */
public class ProduitService implements IProduitService {

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
        final IProduitDao iProduitDao = Factory.getInstance(IProduitDao.class);
        final List<ProduitDo> listeProduitDo = iProduitDao.findAllProduitOrderBy(orderBy);
        return ProduitMapper.mapToListDto(listeProduitDo);
    }

    @Override
    public ProduitDto getProduitById(final int idProduit) {
        final IProduitDao iProduitDao = Factory.getInstance(IProduitDao.class);
        // on pourrait ne pas utiliser cette variable
        final ProduitDo produitDo = iProduitDao.findProduitById(idProduit);
        return ProduitMapper.mapToDto(produitDo);
    }
}
