package presentation.users.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.users.beanDto.UserDto;
import service.users.IUserService;
import util.Factory;

/**
 * @author Administrateur
 *
 */
public class ListerUserAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        // on récupère les données du Service
        final IUserService iUserService = Factory.getInstance(IUserService.class);
        final List<UserDto> listeUserDto = iUserService.findAllUserDto();
        // on les met à disposition de la vue
        request.setAttribute("listeUser", listeUserDto);
        // on va chercher le forward
        return mapping.findForward("success");
    }

}
