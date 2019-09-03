/**
 * 
 */
package presentation.users.beanDto;

import presentation.users.TypeDeProfil;

/**
 * @author Administrateur
 *
 */
public class ConnectedUserDto {
    private Integer      id;
    private String       nom;
    private TypeDeProfil profil;
    private boolean      actif;

    /**
     * @return the actif
     */
    public boolean isActif() {
        return actif;
    }

    /**
     * @param actif the actif to set
     */
    public void setActif(final boolean actif) {
        this.actif = actif;
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
