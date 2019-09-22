package presentation.users.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import util.tools.Tools;

/**
 * Form permettant à un user de s'inscrire
 * 
 * @author Administrateur
 *
 */
public class UserForm extends ActionForm {

    /**
     * Clé de hashage de userform
     */
    private static final long serialVersionUID = 6398705056600842929L;

    private String            id;
    private String            nom;
    private String            prenom;
    private String            dateNaissance;
    private String            adresse;
    private String            password;
    private String            confirmpassword;
    private String            mail;
    private String            profil;

    @Override
    public void reset(final ActionMapping mapping, final HttpServletRequest request) {
        // empty method
    }

    @Override
    public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
        final ActionErrors errors = new ActionErrors();
        if (Tools.isEmpty(mail)) {
            errors.add("mail", new ActionMessage("USR_01.errors.mail.obligatoire"));
        } else {
            if (!Tools.verifMail(mail)) {
                errors.add("mail", new ActionMessage("USR_01.errors.mail.pattern"));
            }
        }
        if (Tools.isEmpty(password)) {
            errors.add("password", new ActionMessage("USR_01.errors.password.obligatoire"));
        }
        if (Tools.isEmpty(nom)) {
            errors.add("nom", new ActionMessage("USR_01.errors.nom.obligatoire"));
        }
        if (Tools.isEmpty(prenom)) {
            errors.add("prenom", new ActionMessage("USR_01.errors.prenom.obligatoire"));
        }
        if (Tools.isEmpty(adresse)) {
            errors.add("adresse", new ActionMessage("USR_01.errors.adresse.obligatoire"));
        }
        if (Tools.isEmpty(dateNaissance)) {
            errors.add("dateNaissance", new ActionMessage("USR_01.errors.dateNaissance.obligatoire"));
        } else if (!Tools.verifDate(dateNaissance)) {
            errors.add("dateNaissance", new ActionMessage("USR_01.errors.dateNaissance.format"));
        }

        if (Tools.isEmpty(confirmpassword)) {
            errors.add("confirmpassword", new ActionMessage("USR_01.errors.confirmpassword.obligatoire"));
        } else if (!password.equals(confirmpassword)) {
            errors.add("password", new ActionMessage("USR_01.errors.password.match"));
        }
        
        if (Tools.isEmpty(profil)) {
            errors.add("profil", new ActionMessage("USR_01.errors.profil.obligatoire"));
        }
        return errors;
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
    public String getDateNaissance() {
        return dateNaissance;
    }

    /**
     * @param dateNaissance the dateNaissance to set
     */
    public void setDateNaissance(final String dateNaissance) {
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
     * @return the confirmpassword
     */
    public String getConfirmpassword() {
        return confirmpassword;
    }

    /**
     * @param confirmpassword the confirmpassword to set
     */
    public void setConfirmpassword(final String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @return the profil
     */
    public String getProfil() {
        return profil;
    }

    /**
     * @param profil the profil to set
     */
    public void setProfil(final String profil) {
        this.profil = profil;
    }

}
