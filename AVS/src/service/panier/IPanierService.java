package service.panier;

import presentation.panier.beanDto.PanierDto;

/**
 * @author Nora LIFERKI
 *
 *         Interface permettant de d�clarer les m�thodes du business service PanierService
 */
public interface IPanierService {

    /**
     * M�thode permettant de faire appel � un produit de la couche persistance pour l'ajouter au panier qu'on ajoute � la BDD
     * 
     * @param panierDto qui contient les infos des produits � ajouter au panier
     * @return un panierDto si ajout OK, sinon null
     */
    PanierDto addProduitPanier(final PanierDto panierDto, final int idProduit);
}
