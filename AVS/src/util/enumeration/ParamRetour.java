package util.enumeration;

/**
 * Enumeration des diff�rents types de param�tres de retour
 * 
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
     * retourne le type de parametreRetour associe au String pass� en parametre
     * 
     * @param paramRetour
     * @return un element de l'enum de type ParamRetour ou null si pas trouv�
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