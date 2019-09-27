package service.panier;

import persistance.commande.beanDo.CommandeDo;
import presentation.panier.beanDto.CommandeInfoDto;
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
     * @param idProduit l'id du produit à rajouter
     * @return un panierDto si ajout OK, sinon null
     */

    PanierDto addProduitPanier(final PanierDto panierDto, final int idProduit);

    /**
     * Permet de calculer la remise sur le panier quand le seuil de 6 articles à 100 euros est atteint
     * 
     * @param panierDto
     * @return le panierDto
     */
    PanierDto remisePanier(final PanierDto panierDto);

    /**
     * Méthode permettant de faire appel à un produit de la couche persistance pour le supprimer du panier Permet de valider le panier et de créer la commande associée
     * 
     * @param panierDto le panier à valider
     * @param commandeInfoDto les infos (userId, adresses)
     * @return la commande, null sinon
     */
    CommandeDo validerPanier(final PanierDto panierDto, final CommandeInfoDto commandeInfoDto);

    /**
     * Méthode permettant de faire appel à un produit de la couche persistance pour le supprimer du panier
     * 
     * @param panierDto qui contient les infos des produits à supprimer du panier
     * @param idProduit l'id du produit à supprimer
     * @return un panierDto si supp OK, sinon null
     */
    PanierDto deleteProduitPanier(final PanierDto panierDto, final int idProduit);

    /**
     * Permet de vider le panier
     * 
     * @param panierDto à vider
     * @return panierDto vide
     */
    PanierDto viderPanierDto(final PanierDto panierDto);
}
