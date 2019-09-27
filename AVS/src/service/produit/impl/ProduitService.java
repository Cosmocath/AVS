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
    public List<ProduitDto> findAllProduitAdminOrderBy(final OrderBy orderBy) {
        final IProduitDao iProduitDao = Factory.getInstance(IProduitDao.class);
        final List<ProduitDo> listeProduitDo = iProduitDao.findAllProduitAdminOrderBy(orderBy);
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

    @Override
    public ProduitDto getProduitById(final int idProduit) {
        final IProduitDao iProduitDao = Factory.getInstance(IProduitDao.class);
        // on pourrait ne pas utiliser cette variable
        final ProduitDo produitDo = iProduitDao.findProduitById(idProduit);
        return ProduitMapper.mapToDto(produitDo);
    }

    @Override
    public ProduitDto updateProduit(final ProduitDto produitDto) {
        final IProduitDao iProduitDao = Factory.getInstance(IProduitDao.class);
        // on recherche d abord si la nouvelle reference existe deja en BD
        ProduitDo produitDo = iProduitDao.findByReference(produitDto.getReference());
        // soit il n'y a pas de produit qui possede deja cette reference, soit c est le meme produit
        if (produitDo == null || produitDo.getId().equals(produitDto.getId())) {
            produitDo = iProduitDao.updateProduit(produitDto.getId(), ProduitMapper.mapToDo(produitDto));
            return ProduitMapper.mapToDto(produitDo);
        }
        return null;
    }

}
