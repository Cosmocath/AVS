package service.produit;

import java.util.List;

import presentation.produit.beanDto.ProduitDto;
import util.enumeration.OrderBy;

/**
 * 
 * Interface permettant de d�clarer les m�thodes du business service ProduitService
 * 
 * @author Nora Liferki
 *
 */
public interface IProduitService {

    /**
     * M�thode permettant de trier la liste par ordre alphab�tique asc ou desc
     * 
     * @param enum {@link OrderBy} asc ou desc
     * @return la liste des produits par ordre alphab�tique
     */
    List<ProduitDto> findAllProduitOrderBy(final OrderBy orderBy);

    /**
     * M�thode permettant de trier la liste par ordre alphab�tique asc ou desc (cette liste n'est visible que par l'administrateur)
     * 
     * @param enum {@link OrderBy} asc ou desc
     * @return la liste de tous les produits dans l'ordre alphab�tique (disponibles et indisponibles)
     */
    List<ProduitDto> findAllProduitAdminOrderBy(final OrderBy orderBy);

    /**
     * Cr�ation d'un produit
     * 
     * @param le produit � cr�er
     * @return le produit cr��
     */
    ProduitDto create(final ProduitDto produitDto);

    /**
     * Permet de faire appel � la couche persistance afin de rechercher un Produit en BDD � partir de son id
     * 
     * @param idProduit = id du Produit recherch�
     * @return un ProduitDto contenant les informations du Produit recherch�, null si non existant
     */

    ProduitDto getProduitById(final int idProduit);

    /**
     * V�rifie que la version du produit stock� dans le panier est bien en phase avec la table Produit
     * 
     * @param idProduit
     * @param noVersion
     * @return le bool�en indiquant que c'est le m�me No de version
     */
    boolean isProduitFromPanierUpToDate(final int idProduit, final int noVersion);
}
