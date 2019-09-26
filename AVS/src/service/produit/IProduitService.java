package service.produit;

import java.util.List;

import presentation.produit.beanDto.ProduitDto;
import util.enumeration.OrderBy;

/**
 * 
 * Interface permettant de déclarer les méthodes du business service ProduitService
 * 
 * @author Nora Liferki
 *
 */
public interface IProduitService {

    /**
     * Méthode permettant de trier la liste par ordre alphabétique asc ou desc
     * 
     * @param enum {@link OrderBy} asc ou desc
     * @return la liste des produits par ordre alphabétique
     */
    List<ProduitDto> findAllProduitOrderBy(final OrderBy orderBy);

    /**
     * Méthode permettant de trier la liste par ordre alphabétique asc ou desc (cette liste n'est visible que par l'administrateur)
     * 
     * @param enum {@link OrderBy} asc ou desc
     * @return la liste de tous les produits dans l'ordre alphabétique (disponibles et indisponibles)
     */
    List<ProduitDto> findAllProduitAdminOrderBy(final OrderBy orderBy);

    /**
     * Création d'un produit
     * 
     * @param le produit à créer
     * @return le produit créé
     */
    ProduitDto create(final ProduitDto produitDto);

    /**
     * Permet de faire appel à la couche persistance afin de rechercher un Produit en BDD à partir de son id
     * 
     * @param idProduit = id du Produit recherché
     * @return un ProduitDto contenant les informations du Produit recherché, null si non existant
     */
    ProduitDto getProduitById(final int idProduit);

    /**
     * Permet de faire appel à la couche persistance afin de modifier un Produit en BDD à partir de son id 
     * </br>On applique les règles de gestion.
     * @param idProduit : l id du produit que l on souhaite modifier
     * @param produitDto contenant les informations du produit à modifier en BDD
     * @return un produitDto si la modification à fonctionné, null dans le cas contraire *
     */
    ProduitDto updateProduit(final Integer idProduit, final ProduitDto produitDto);

}
