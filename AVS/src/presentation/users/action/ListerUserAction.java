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
import util.enumeration.OrderBy;
import util.factory.Factory;

/**
 * permet de lister une liste d'utilisateur actif
 * 
 * @author Administrateur
 *
 */
public class ListerUserAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        // on récupère les données du Service
        final IUserService iUserService = Factory.getInstance(IUserService.class);
        // on recupère le paramètre de la request et on le cast
        final String paramOrderBy = request.getParameter("orderBy");
        OrderBy enumOrderBy = OrderBy.ASC;
        if (paramOrderBy != null && !paramOrderBy.isEmpty()) {
            // on le convertit en enum
            enumOrderBy = OrderBy.valueOf(paramOrderBy);
        }
        // on appelle la methode
        final List<UserDto> listeUserDto = iUserService.findAllUserOrderBy(enumOrderBy);

        // si la methode a fonctionné en mode ascendant, alors on passe le parametre descendant en requete, et vice versa
        if (enumOrderBy == OrderBy.ASC) {
            request.setAttribute("TRI", OrderBy.DESC);
        } else {
            request.setAttribute("TRI", OrderBy.ASC);
        }

        // on les met à disposition de la vue
        request.setAttribute("listeUser", listeUserDto);
        // on va chercher le forward
        return mapping.findForward("success");
    }

}
