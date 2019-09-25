package presentation.panier.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.panier.form.PanierForm;

/**
 * permet de valider le panier
 * 
 * @author Guy-Joël
 *
 */
public class ValiderPanierAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final PanierForm panierForm = (PanierForm) form;
        return mapping.findForward("success");
    }

}
