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
// TODO XSI : à revoir : extends IFactoryImpl<IProduitService>
public interface IProduitService {

    /**
     * @param listeProduitDo
     * @return la liste des produits par ordre alphabétique
     */
    List<ProduitDto> findAllProduitOrderBy(final List<ProduitDto> listeProduitDo);

}
