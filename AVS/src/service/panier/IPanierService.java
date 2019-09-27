package service.panier;

import persistance.commande.beanDo.CommandeDo;
import presentation.panier.beanDto.CommandeInfoDto;
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
     * @param idProduit l'id du produit � rajouter
     * @return un panierDto si ajout OK, sinon null
     */

    PanierDto addProduitPanier(final PanierDto panierDto, final int idProduit);

    /**
     * Permet de calculer la remise sur le panier quand le seuil de 6 articles � 100 euros est atteint
     * 
     * @param panierDto
     * @return le panierDto
     */
    PanierDto remisePanier(final PanierDto panierDto);

    /**
     * M�thode permettant de faire appel � un produit de la couche persistance pour le supprimer du panier Permet de valider le panier et de cr�er la commande associ�e
     * 
     * @param panierDto le panier � valider
     * @param commandeInfoDto les infos (userId, adresses)
     * @return la commande, null sinon
     */
    CommandeDo validerPanier(final PanierDto panierDto, final CommandeInfoDto commandeInfoDto);

    /**
     * M�thode permettant de faire appel � un produit de la couche persistance pour le supprimer du panier
     * 
     * @param panierDto qui contient les infos des produits � supprimer du panier
     * @param idProduit l'id du produit � supprimer
     * @return un panierDto si supp OK, sinon null
     */
    PanierDto deleteProduitPanier(final PanierDto panierDto, final int idProduit);

    /**
     * Permet de vider le panier
     * 
     * @param panierDto � vider
     * @return panierDto vide
     */
    PanierDto viderPanierDto(final PanierDto panierDto);
}
