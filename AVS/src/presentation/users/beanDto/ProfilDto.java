package presentation.users.beanDto;

/**
 * Bean pour le type de profil
 * 
 * @author Administrateur
 *
 */
public class ProfilDto {

    private Integer id;
    private String  nom;

    /**
     * constructeur du profil dto
     */
    public ProfilDto() {
        //empty method
    }

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
