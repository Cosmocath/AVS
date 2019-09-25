package persistance.produit.dao;

import java.util.List;

import persistance.produit.beanDo.ProduitDo;
import util.enumeration.OrderBy;

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

    /**
     * Affiche la liste de tous les produits dans l'ordre alphab�tique. cette liste sera visible pour l'administrateur uniquement
     * 
     * @param enum {@link OrderBy} asc ou desc
     * @return la liste de tous les produits dans l'ordre alphab�tique (disponibles et indisponibles)
     */
    List<ProduitDo> findAllProduitAdminOrderBy(final OrderBy orderBy);

    /**
     * Cr�e un produit
     * 
     * @param produitDo : le produit � cr�er
     * @return le produit cr��
     */
    ProduitDo createProduit(final ProduitDo produitDo);

    /**
     * Permet de rechercher un produit selon sa r�f�rence
     * 
     * @param reference
     * @return le produit si existant, null sinon
     */
    ProduitDo findByReference(final String reference);

    /**
     * Permet de rechercher un produit selon son Id
     * 
     * @param idProduit du produit recherch�
     * @return le produit recherch�, null sinon
     */
    ProduitDo findProduitById(final Integer idProduit);

    /**
     * Permet de mettre � jour un produit
     * 
     * @param idProduit l id du produit a mettre a jour
     * @param produitDo le produit
     * @return le produit mis a jour, null en cas de probleme
     */
    ProduitDo updateProduit(final Integer idProduit, final ProduitDo produitDo);
}
