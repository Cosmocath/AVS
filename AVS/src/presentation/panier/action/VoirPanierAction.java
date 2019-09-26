package presentation.panier.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import presentation.panier.beanDto.PanierDto;
import presentation.users.action.ConnecterUserAction;

/**
 * Permet d'afficher le panierDto de la session
 * 
 * @author Administrateur
 *
 */
public class VoirPanierAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final HttpSession session = request.getSession();
        final PanierDto panierDto = (PanierDto) session.getAttribute(ConnecterUserAction.MON_PANIER);
        //message panier vide
        if (panierDto.getQuantiteTotale() == 0) {
            final ActionMessages messages = new ActionMessages();
            messages.add("panierVide", new ActionMessage("PAN_00.panierVide"));
            saveMessages(request, messages);
        }
        return mapping.findForward("success");
    }

}
