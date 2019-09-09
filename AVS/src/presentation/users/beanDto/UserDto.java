package presentation.users.beanDto;

import util.TypeDeProfil;

/**
 * @author Administrateur
 *
 */
public class UserDto {
    private Integer      id;
    private String       nom;
    private TypeDeProfil profil;

    public UserDto() {
        //emty method
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

    /**
     * @return the profil
     */
    public TypeDeProfil getProfil() {
        return profil;
    }

    /**
     * @param profil the profil to set
     */
    public void setProfil(final TypeDeProfil profil) {
        this.profil = profil;
    }

}
