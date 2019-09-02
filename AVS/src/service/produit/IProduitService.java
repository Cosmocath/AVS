/**
 * 
 */
package service.produit;

import java.util.List;

import presentation.produit.beanDto.ProduitDto;
import util.OrderBy;

/**
 * @author Nora Liferki Interface IProduitService
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
}
