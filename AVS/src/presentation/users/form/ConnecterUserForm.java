package presentation.users.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import util.Tools;

/**
 * Form permettant à un user de se connecter
 * 
 * @author Administrateur
 *
 */
public class ConnecterUserForm extends ActionForm {

    /**
     * 
     */
    private static final long serialVersionUID = 6398705056600842929L;

    private String            mail;
    private String            password;

    @Override
    public void reset(final ActionMapping mapping, final HttpServletRequest request) {
        // empty method
    }

    @Override
    public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
        final ActionErrors errors = new ActionErrors();
        if (Tools.isEmpty(mail)) {
            errors.add("mail", new ActionMessage("USR_00.errors.mail.obligatoire"));
        }
        if (Tools.isEmpty(password)) {
            errors.add("password", new ActionMessage("USR_00.errors.password.obligatoire"));
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

}
