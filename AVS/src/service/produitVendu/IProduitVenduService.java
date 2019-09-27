package service.produitVendu;

import persistance.produitVendu.beanDo.ProduitVenduDo;
import presentation.produit.beanDto.ProduitDto;
import presentation.produitVendu.beanDto.ProduitVenduDto;

/**
 * Service de gestion des produits vendus
 * 
 * @author Guy-Joël Valentin
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

    /**
     * Permet de mapper un ProduitVenduDo en produitVenduDto
     * 
     * @param produitVendu
     * @return le ProduitVenduDto
     */
    ProduitVenduDto mapProduitDoToDto(final ProduitVenduDo produitVenduDo);
}
