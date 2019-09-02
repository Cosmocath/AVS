/**
 * 
 */
package persistance.produit.dao;

import java.util.List;

import persistance.produit.beanDo.ProduitDo;
import util.OrderBy;

/**
 * @author Nora Liferki
 *
 */
public interface IProduitDao {

    /**
     * Affiche la liste de produits dans l'ordre alphabétique
     * 
     * @return une liste de produits
     * @param enum {@link OrderBy} asc ou desc
     */
    List<ProduitDo> findAllProduitOrderBy(final OrderBy orderBy);
}
