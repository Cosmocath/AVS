package service.produit;

import java.util.List;

import presentation.produit.beanDto.ProduitDto;
import util.OrderBy;

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
}
