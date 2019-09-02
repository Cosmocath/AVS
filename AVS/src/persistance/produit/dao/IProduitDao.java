/**
 * 
 */
package persistance.produit.dao;

import java.util.List;

import persistance.produit.beanDo.ProduitDo;

/**
 * @author Nora Liferki
 *
 */
public interface IProduitDao {

    /**
     * Affiche la liste de produits dans l'ordre alphabétique
     * 
     * @return une liste de produits
     */
    //TODO trouver urgemment le fonctionnement du parametre de la méthode => enum
    List<ProduitDo> findAllProduitOrderBy();
}
