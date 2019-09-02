/**
 * 
 */
package service.produit;

import java.util.List;

import presentation.produit.beanDto.ProduitDto;

/**
 * @author Nora Liferki
 *
 */
// TODO XSI : � revoir : extends IFactoryImpl<IProduitService>
public interface IProduitService {

    /**
     * @param listeProduitDo
     * @return la liste des produits par ordre alphab�tique
     */
    List<ProduitDto> findAllProduitOrderBy(final List<ProduitDto> listeProduitDo);

}
