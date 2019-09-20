/**
 * 
 */
package util.enumeration;

/**
 * parametres utilises pour le bouton retour de la Jsp consulterProduit
 * @author Catherine Hermary
 *
 */
public enum ParamRetour {
    PRODUIT_CLIENT("produitClient"),PRODUIT_ADMIN("produitAdmin"),PANIER("panier"),COMMANDE("commande");
    private String paramRetour;
    
    private ParamRetour(final String paramRetour) {
        this.paramRetour=paramRetour;
    }

    
 
}

