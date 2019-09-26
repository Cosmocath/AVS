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
     * Permet de faire appel � la couche persistance afin de modifier un Produit en BDD � partir de son id 
     * </br>On applique les r�gles de gestion.
     * @param idProduit : l id du produit que l on souhaite modifier
     * @param produitDto contenant les informations du produit � modifier en BDD
     * @return un produitDto si la modification � fonctionn�, null dans le cas contraire *
     */
    ProduitDto updateProduit(final Integer idProduit, final ProduitDto produitDto);

}
