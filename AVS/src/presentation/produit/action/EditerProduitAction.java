/**
 * 
 */
package presentation.produit.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Catherine
 *
 */
public class EditerProduitAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping,final ActionForm form,final HttpServletRequest request,final HttpServletResponse response) throws Exception {
        // On redirige 
        return mapping.findForward("success");
    }
    

}
