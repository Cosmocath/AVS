package persistance.produit.dao;

import java.util.List;

import persistance.produit.beanDo.ProduitDo;
import util.OrderBy;

/**
 * 
 * Ensemble des m�thodes pour le Dao
 * 
 * @author Nora Liferki
 *
 */
public interface IProduitDao {

    /**
     * Affiche la liste de produits dans l'ordre alphab�tique
     * 
     * @param enum {@link OrderBy} asc ou desc
     * @return une liste de produits
     */
    List<ProduitDo> findAllProduitOrderBy(final OrderBy orderBy);
}
