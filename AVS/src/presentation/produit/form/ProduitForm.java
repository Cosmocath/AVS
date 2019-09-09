package presentation.produit.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import util.Tools;

/**
 * Formulaire pour la saisie d'un produit
 * 
 * @author Rodolphe
 *
 */
public class ProduitForm extends ActionForm {

    /**
     * 
     */
    private static final long serialVersionUID = -6080826135423756585L;

    /**
     * Pour le champ caché de la modif
     */
    private String            idProduit;
    private String            designation;
    private String            reference;
    private String            description;
    private String            prix;
    private String            image;

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        // empty method
    }

    @Override
    public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
        final ActionErrors errors = new ActionErrors();
        if (Tools.isEmpty(designation)) {
            errors.add("designation", new ActionMessage("PDT_02.designation.mandatory"));
        }
        if (Tools.isEmpty(reference)) {
            errors.add("reference", new ActionMessage("PDT_02.reference.mandatory"));
        }
        if (Tools.isEmpty(description)) {
            errors.add("description", new ActionMessage("PDT_02.description.mandatory"));
        }
        if (Tools.isEmpty(prix)) {
            errors.add("prix", new ActionMessage("PDT_02.price.mandatory"));
        } else {
            if (!Tools.verifPrix(prix)) {
                errors.add("prix", new ActionMessage("PDT_02.price.format.numeric"));
            }
        }
        if (!errors.isEmpty()) {
            errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("PDT_02.valid.failure"));
        }
        return errors;
    }

    /**
     * @return the idProduit
     */
    public String getIdProduit() {
        return idProduit;
    }

    /**
     * @param idProduit the idProduit to set
     */
    public void setIdProduit(final String idProduit) {
        this.idProduit = idProduit;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(final String designation) {
        this.designation = designation;
    }

    /**
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(final String reference) {
        this.reference = reference;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @return the prix
     */
    public String getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(final String prix) {
        this.prix = prix;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(final String image) {
        this.image = image;
    }

}
