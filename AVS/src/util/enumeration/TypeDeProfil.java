package util.enumeration;

/**
 * Énumeration des 3 type de profil
 * 
 * @author Administrateur
 *
 */
public enum TypeDeProfil {
    VISITEUR("visiteur"), CLIENT("client"), ADMINISTRATEUR("admin");
    private String nomBD;

    /**
     * Constructeur
     * 
     * @param nomBD
     */
    private TypeDeProfil(final String nomBD) {
        this.nomBD = nomBD;
    }

    /**
     * retourne le TypeDeProfil associé au String passé en param
     * .
     * @param nomBD : le nom de type de profilassocié en BD
     * @return le type de profil
     */
    public static TypeDeProfil getValue(final String nomBD) {
        for (final TypeDeProfil type : TypeDeProfil.values()) {
            if (type.nomBD.equals(nomBD)) {
                return type;
            }
        }
        return null;
    }

}
