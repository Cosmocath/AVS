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
 * Impl�mentation du service pour g�rer les produits
 * 
 * @author Nora Liferki
 *
 */
public class ProduitService implements IProduitService {

    // SINGLETON QUI COMPREND UNIQUEMENT UN CONSTRUCTEUR Private => plus besoin de l'instance et du getInstance gr�ce � la factory de XSI

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
    public ProduitDto create(final ProduitDto produitDto) {
        // r�cup�ration de la couche persistance
        final IProduitDao iProduitDao = Factory.getInstance(IProduitDao.class);
        // la couche m�tier prend en charge la v�rification de la non-existence de la r�f�rence en base en base (sinon insertion annul�e)
        if (iProduitDao.findByReference(produitDto.getReference()) != null) {
            return null;
        }
        // on peut ins�rer
        final ProduitDo produitDoNew = iProduitDao.createProduit(ProduitMapper.mapDtoToDo(produitDto));
        // transformation en Dto
        if (produitDoNew != null) {
            return ProduitMapper.mapToDto(produitDoNew);
        }
        return null;
    }

    // TODO XSI : @Override
    public ProduitDto getProduitById(final int idProduit) {
        final IProduitDao iProduitDao = Factory.getInstance(IProduitDao.class);
        // on pourrait ne pas utiliser cette variable
        final ProduitDo produitDo = iProduitDao.findProduitById(idProduit);
        return ProduitMapper.mapToDto(produitDo);
    }
}
