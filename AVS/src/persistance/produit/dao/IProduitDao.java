package persistance.produit.dao;

import java.util.List;

import persistance.produit.beanDo.ProduitDo;
import util.OrderBy;

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
     * Affiche la liste de tous les produits dans l'ordre alphabétique. cette liste sera visible pour l'administrateur uniquement
     * 
     * @param enum {@link OrderBy} asc ou desc
     * @return la liste de tous les produits dans l'ordre alphabétique (disponibles et indisponibles)
     */
    List<ProduitDo> findAllProduitAdminOrderBy(final OrderBy orderBy);

    /**
     * Permet de rechercher un produit selon son Id
     * 
     * @param idProduit du produit recherché
     * @return le produit recherché, null sinon
     */
    ProduitDo findProduitById(final Integer idProduit);
}
