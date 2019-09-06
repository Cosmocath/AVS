/**
 * 
 */
package persistance.droit.beanDo;

/**
 * @author Administrateur
 *
 */
public class ProfilDo {
    private Integer idProfil;
    private String  nom;

    /**
     * 
     */
    public ProfilDo() {
        // Empty method
    }

    /**
     * @return the idProfil
     */
    public Integer getIdProfil() {
        return idProfil;
    }

    /**
     * @param idProfil the idProfil to set
     */
    public void setIdProfil(final Integer idProfil) {
        this.idProfil = idProfil;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(final String nom) {
        this.nom = nom;
    }

}
