package presentation.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import presentation.users.beanDto.UserDto;
import presentation.users.form.UserForm;
import service.users.IUserService;
import service.users.impl.UserMapper;
import util.factory.Factory;

/**
 * Action permettant de connecter un user
 * 
 * @author Administrateur
 *
 */
public class CreerUserAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final UserForm userForm = (UserForm) form;
        final IUserService iUserService = Factory.getInstance(IUserService.class);

        final UserDto userDto = iUserService.createUser(UserMapper.mapFormToDto(userForm));

        if (userDto == null) {
            final ActionErrors errors = new ActionErrors();
            errors.add("error", new ActionMessage("USR_01.errors.creation"));
            saveErrors(request, errors);
            return mapping.findForward("notSuccess");

        } else {
            final ActionMessages messages = new ActionMessages();
            messages.add("creationOK", new ActionMessage("creer.ok"));
            saveMessages(request, messages);
            return mapping.findForward("success");
        }
    }

}
