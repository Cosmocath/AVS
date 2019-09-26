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
 * @author Guy-Jo�l
 *
 */
public class VoirValiderPanierAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        //je recup�re la session
        final HttpSession session = request.getSession();
        //je recup�re le profil qui est en session
        final ConnectedUserDto connectedUser = (ConnectedUserDto) session.getAttribute(ConnecterUserAction.USER_CONNECTED);
        //je recup�re l'id du connectedUser
        final int id = Integer.valueOf(connectedUser.getId());
        final IUserService iUserService = Factory.getInstance(IUserService.class);
        //on recup�re l'adresse de l'userDtos
        final String adresseUserDto = iUserService.findUserDto(id).getAdresse();
        //adresse mise en request
        request.setAttribute("adresse", adresseUserDto);
        return mapping.findForward("success");
    }

}
