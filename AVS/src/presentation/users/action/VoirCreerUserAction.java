package presentation.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Action permettant d'aller à la page de connexion d'un user
 * 
 * @author Administrateur
 *
 */
public class VoirCreerUserAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        return mapping.findForward("success");
    }
}
