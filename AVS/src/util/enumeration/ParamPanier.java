package util.enumeration;

/**
 * Enumeration des différents types de paramètres de retour pour le panier
 * 
 * @author Nora LIFERKI
 * 
 */
public enum ParamPanier {
    LISTE_PRODUIT_CLIENT("listeProduitClient"), CONSULTER_PRODUIT("consulterProduit"), PANIER("panier");
    private String paramPanier;

    /**
     * Constructeur
     * 
     * @param paramRetour
     */
    private ParamPanier(final String paramPanier) {
        this.paramPanier = paramPanier;
    }

    /**
     * retourne le type de parametreRetour associe au String passé en parametre
     * 
     * @param ParamPanier
     * @return un element de l'enum de type ParamPanier ou null si pas trouvé
     */
    public static ParamPanier getValue(final String paramPanier) {
        for (final ParamPanier type : ParamPanier.values()) {
            if (type.paramPanier.equals(paramPanier)) {
                return type;
            }
        }
        return null;
    }

    /**
     * @return the paramPanier
     */
    public String getParamPanier() {
        return paramPanier;
    }
}
