package util;

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
     * @param nomBD
     */
    private TypeDeProfil(final String nomBD) {
        this.nomBD = nomBD;
    }

    /**
     * @return the nomBD
     */
    public String getNomBD() {
        return nomBD;
    }

    public static TypeDeProfil getValue(final String nomBD) {
        for (TypeDeProfil type : TypeDeProfil.values()) {
            if (type.nomBD == nomBD) {
                return type;
            }
        }
        return null;
    }

}
