package presentation.panier.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.panier.beanDto.PanierDto;
import presentation.users.action.ConnecterUserAction;
import service.panier.IPanierService;
import util.factory.Factory;

/**
 * Permet de vider le panier en session
 * 
 * @author Administrateur
 *
 */
public class ViderPanierAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {

        //je recup�re la session
        final HttpSession session = request.getSession();
        //je recup�re le panier en session
        final PanierDto panierDto = (PanierDto) session.getAttribute(ConnecterUserAction.MON_PANIER);
        //je vide la panierDto
        final IPanierService iPanierService = Factory.getInstance(IPanierService.class);
        iPanierService.viderPanierDto(panierDto);

        //je retourne la direction
        return mapping.findForward("success");
    }

}
