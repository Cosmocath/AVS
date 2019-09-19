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
     * Permet de faire appel � la couche persistance afin de rechercher un Produit en BDD � partir de son id
     * 
     * @param idProduit = id du Produit recherch�
     * @return un ProduitDto contenant les informations du Produit recherch�, null si non existant
     */
    ProduitDto getProduitById(final int idProduit);
}
