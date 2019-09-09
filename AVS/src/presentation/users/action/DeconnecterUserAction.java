package presentation.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Action permettant de déconnecter un user
 * 
 * @author Administrateur
 *
 */
public class DeconnecterUserAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final HttpSession session = request.getSession();
        session.removeAttribute(ConnecterUserAction.USER_CONNECTED);
        session.invalidate();
        return mapping.findForward("success");
    }
}
