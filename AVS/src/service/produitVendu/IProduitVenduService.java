package service.produitVendu;

import java.util.Map;

import persistance.produitVendu.beanDo.ProduitVenduDo;
import presentation.panier.beanDto.PanierDto;
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

    /**
     * Construction de la map ProduitVendu/Quantité
     * 
     * @param panierDto
     * @return la map clé : ProduitVenduDo, valeur : quantité
     */
    Map<ProduitVenduDo, Integer> buildMapProduitVenduQuantite(final PanierDto panierDto);
}
