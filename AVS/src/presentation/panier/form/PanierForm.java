package presentation.panier.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import util.tools.Tools;

/**
 * permet de recuperer la saisie du formulaire
 * 
 * @author Guy-Joel
 *
 */
public class PanierForm extends ActionForm {

    /**
     * Clé de hashage de panierform
     */
    private static final long serialVersionUID = -4179931651944689379L;

    private String            adresseLivraison;
    private String            adresseFacturation;

    /**
     * Constructeur par defaut
     */
    public PanierForm() {
        // Empty method
    }

    @Override
    public void reset(final ActionMapping mapping, final HttpServletRequest request) {

    }

    @Override
    public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
        final ActionErrors errors = new ActionErrors();
        if (Tools.isEmpty(adresseLivraison)) {
            errors.add("adresseLivraison", new ActionMessage("PAN_01.errors.adresse.livraison.obligatoire"));
        }
        if (Tools.isEmpty(adresseFacturation)) {
            errors.add("adresseFacturation", new ActionMessage("PAN_01.errors.adresse.facturation.obligatoire"));
        }
        return errors;
    }

    /**
     * @return the adresseLivraison
     */
    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    /**
     * @param adresseLivraison the adresseLivraison to set
     */
    public void setAdresseLivraison(final String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    /**
     * @return the adresseFacturation
     */
    public String getAdresseFacturation() {
        return adresseFacturation;
    }

    /**
     * @param adresseFacturation the adresseFacturation to set
     */
    public void setAdresseFacturation(final String adresseFacturation) {
        this.adresseFacturation = adresseFacturation;
    }

}
