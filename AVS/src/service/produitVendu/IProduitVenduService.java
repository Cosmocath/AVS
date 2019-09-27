package service.produitVendu;

import persistance.produitVendu.beanDo.ProduitVenduDo;
import presentation.produit.beanDto.ProduitDto;

/**
 * Service de gestion des produits vendus
 * 
 * @author Guy-Joël
 *
 */
public interface IProduitVenduService {
    
    
    /**
     * Permet de mapper un ProduitDto en produitVenduDo
     * 
     * @param produitDto le produitDto 
     * @return le ProduitVenduDo
     */
    ProduitVenduDo mapProduitDtoToProduitVenduDo(final ProduitDto produitDto);
}
