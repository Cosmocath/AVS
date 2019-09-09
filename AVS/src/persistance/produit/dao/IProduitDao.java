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
     * Crée un produit
     * 
     * @param produitDo : le produit à créer
     * @return le produit créé
     */
    ProduitDo createProduit(final ProduitDo produitDo);

    /**
     * Permet de rechercher un produit selon sa référence
     * 
     * @param reference
     * @return le produit si existant, null sinon
     */
    ProduitDo findByReference(final Integer reference);
}
