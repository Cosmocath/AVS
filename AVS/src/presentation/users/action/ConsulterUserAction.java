package presentation.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.users.beanDto.UserDto;
import service.users.IUserService;
import util.factory.Factory;

/**
 * @author Administrateur
 *
 */
public class ConsulterUserAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final String id = request.getParameter("id");
        final IUserService iUserService = Factory.getInstance(IUserService.class);
        final UserDto userDto = iUserService.findUserDto(Integer.valueOf(id));
        request.setAttribute("user", userDto);
        return mapping.findForward("success");
    }

}
