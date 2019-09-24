package service.panier;

import presentation.panier.beanDto.PanierDto;

/**
 * @author Nora LIFERKI
 *
 *         Interface permettant de déclarer les méthodes du business service PanierService
 */
public interface IPanierService {

    /**
     * Méthode permettant de faire appel à un produit de la couche persistance pour l'ajouter au panier qu'on ajoute à la BDD
     * 
     * @param panierDto qui contient les infos des produits à ajouter au panier
     * @return un panierDto si ajout OK, sinon null
     */
    PanierDto addProduitPanier(final PanierDto panierDto, final int idProduit);
}
