/**
 * 
 */
package presentation.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import presentation.users.beanDto.ConnectedUserDto;
import presentation.users.form.ConnecterUserForm;
import service.users.IUserService;
import util.Factory;

/**
 * @author Administrateur
 *
 */
public class ConnecterUserAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final HttpSession session = request.getSession();
        // on r�cup�re les infos
        final ConnecterUserForm connecterUserForm = (ConnecterUserForm) form;
        // on r�cup�re les donn�es du Service
        final IUserService iUserService = Factory.getInstance(IUserService.class);
        final ConnectedUserDto connectedUserDto = iUserService.findUserForConnexion(connecterUserForm.getMail(), connecterUserForm.getPassword());
        // on teste le retour du service
        if (connectedUserDto == null) {
            final ActionErrors errors = new ActionErrors();
            errors.add("error", new ActionMessage("errors.connection"));
            saveErrors(request, errors);
            return mapping.findForward("notSuccess");

        } else {
            final ActionMessages messages = new ActionMessages();
            messages.add("creationOK", new ActionMessage("creer.ok"));
            saveMessages(request, messages);
            session.setAttribute("userConnected", connecterUserForm);
            return mapping.findForward("success");
        }
    }

}
