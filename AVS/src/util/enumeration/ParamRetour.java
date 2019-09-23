/**
 * 
 */
package util.enumeration;

/**
 * @author Catherine Hermary
 *
 */
public enum ParamRetour {
    PRODUIT_CLIENT("produitClient"), PRODUIT_ADMIN("produitAdmin"), PANIER("panier"), COMMANDE("commande");
    private String paramRetour;

    /**
     * Constructeur
     * 
     * @param paramRetour
     */
    private ParamRetour(final String paramRetour) {
        this.paramRetour = paramRetour;
    }

    /**
     * retourne le type de parametreRetour associe au String passé en parametre
     * 
     * @param paramRetour
     * @return
     */
    public static ParamRetour getValue(final String paramRetour) {
        for (final ParamRetour type : ParamRetour.values()) {
            if (type.paramRetour.equals(paramRetour)) {
                return type;
            }
        }
        return null;
    }

    /**
     * @return the paramRetour
     */
    public String getParamRetour() {
        return paramRetour;
    }

}
