package persistance.produit.dao;

import java.util.List;

import persistance.produit.beanDo.ProduitDo;
import util.enumeration.OrderBy;

/**
 * 
 * Ensemble des méthodes pour le Dao
 * 
 * @author Nora Liferki
 *
 */
public interface IProduitDao {

    /**
     * Affiche la liste de produits dans l'ordre alphabétique
     * 
     * @param enum {@link OrderBy} asc ou desc
     * @return une liste de produits
     */
    List<ProduitDo> findAllProduitOrderBy(final OrderBy orderBy);

    /**
     * Permet de rechercher un produit selon son Id
     * 
     * @param idProduit du produit recherché
     * @return le produit recherché, null sinon
     */
    ProduitDo findProduitById(final Integer idProduit);
}
