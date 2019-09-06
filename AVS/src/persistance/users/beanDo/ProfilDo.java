package persistance.users.beanDo;

/**
 * Representation du profil pour la bd
 * 
 * @author Administrateur
 *
 */
public class ProfilDo {
    private Integer id;
    private String  nom;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final Integer id) {
        this.id = id;
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
