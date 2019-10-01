package presentation.commande.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.commande.beanDto.CommandeDto;
import presentation.users.action.ConnecterUserAction;
import presentation.users.beanDto.ConnectedUserDto;
import service.commande.ICommandeService;
import util.factory.Factory;

/**
 * Action permettant de visualiser la liste des commandes
 * 
 * @author Administrateur
 *
 */
public class ListerCommandeAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final ICommandeService iCommandeService = Factory.getInstance(ICommandeService.class);
        // recupération du User
        final HttpSession session = request.getSession();
        final ConnectedUserDto connectedUser = (ConnectedUserDto) session.getAttribute(ConnecterUserAction.USER_CONNECTED);

        final Integer id = connectedUser.getId();
        final List<CommandeDto> listeCommandeDto = iCommandeService.findAllCommande(Integer.valueOf(id));
        request.setAttribute("listeCommande", listeCommandeDto);
        return mapping.findForward("success");
    }
}
