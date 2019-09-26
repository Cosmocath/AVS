package presentation.panier.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.users.action.ConnecterUserAction;
import presentation.users.beanDto.ConnectedUserDto;
import service.users.IUserService;
import util.factory.Factory;

/**
 * permet de rediriger vers panierAdresseClient.jsp
 * 
 * @author Guy-Joël
 *
 */
public class VoirValiderPanierAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        //je recupère la session
        final HttpSession session = request.getSession();
        //je recupère le profil qui est en session
        final ConnectedUserDto connectedUser = (ConnectedUserDto) session.getAttribute(ConnecterUserAction.USER_CONNECTED);
        //je recupère l'id du connectedUser
        final int id = Integer.valueOf(connectedUser.getId());
        final IUserService iUserService = Factory.getInstance(IUserService.class);
        //on recupère l'adresse de l'userDtos
        final String adresseUserDto = iUserService.findUserDto(id).getAdresse();
        //adresse mise en request
        request.setAttribute("adresse", adresseUserDto);
        return mapping.findForward("success");
    }

}
