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
    public ProduitDto create(ProduitDto produitDto) {
        // récupération de la couche persistance
        final IProduitDao iProduitDao = Factory.getInstance(IProduitDao.class);
        // la couche métier prend en charge la vérification de la non-existence de la référence en base en base (sinon insertion annulée)
        if (iProduitDao.findByReference(produitDto.getReference()) != null) {
            return null;
        }
        // on peut insérer
        final ProduitDo produitDoNew = iProduitDao.createProduit(ProduitMapper.mapToDo(produitDto));
        // transformation en Dto
        if (produitDoNew != null) {
            return ProduitMapper.mapToDto(produitDoNew);
        }
        return null;
    }

}
