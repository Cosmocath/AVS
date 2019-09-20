package presentation.users.beanDto;

import java.util.Date;

import util.enumeration.TypeDeProfil;

/**
 * Bean d'un utilisateur quelque soit son action
 * 
 * @author Administrateur
 *
 */
public class UserDto {
    private Integer      id;
    private String       nom;
    private String       prenom;
    private Date         dateNaissance;
    private String       adresse;
    private String       password;
    private String       mail;
    private boolean      actif;
    private TypeDeProfil profil;

    /**
     * constructeur du user dto
     */
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
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(final String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the dateNaissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * @param dateNaissance the dateNaissance to set
     */
    public void setDateNaissance(final Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(final String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(final String mail) {
        this.mail = mail;
    }

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
