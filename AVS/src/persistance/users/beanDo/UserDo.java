package persistance.users.beanDo;

import java.util.Date;

/**
 * Representation du user pour la bd
 * 
 * @author Administrateur
 *
 */
public class UserDo {
    private Integer  id;
    private String   nom;
    private String   prenom;
    private Date     dateNaissance;
    private String   adresse;
    private String   password;
    private ProfilDo profilDo;
    private String   mail;
    private boolean  actif;

    /**
     * Instancie un UserDo
     * 
     * @param id
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @param adresse
     * @param password
     * @param profilDo
     * @param mail
     * @param actif
     * @return le user initialiser
     */
    public static UserDo buildUserDo(final Integer id, final String nom, final String prenom, final Date dateNaissance, final String adresse, final String password, final ProfilDo profilDo,
                    final String mail, final boolean actif) {
        final UserDo userDo = new UserDo();
        userDo.id = id;
        userDo.nom = nom;
        userDo.prenom = prenom;
        userDo.dateNaissance = dateNaissance;
        userDo.adresse = adresse;
        userDo.password = password;
        userDo.profilDo = profilDo;
        userDo.mail = mail;
        userDo.actif = actif;

        return userDo;
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
     * @return the profilDo
     */
    public ProfilDo getProfilDo() {
        return profilDo;
    }

    /**
     * @param profilDo the profilDo to set
     */
    public void setProfilDo(final ProfilDo profilDo) {
        this.profilDo = profilDo;
    }

}
