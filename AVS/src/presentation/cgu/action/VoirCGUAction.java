/**
 * 
 */
package presentation.cgu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Administrateur
 *
 */
public class VoirCGUAction extends Action {

    // TODO XSI : il faudra ajouter les url au JDD + fichier excel 
    
    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        return mapping.findForward("success");
    }

}
