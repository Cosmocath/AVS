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
 * @author Nora Liferki
 * 
 *         Action permettant de supprimer un produit du panier
 * 
 *
 */
public class SupprimerPanierAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final IPanierService iPanierService = Factory.getInstance(IPanierService.class);

        final Integer idProduit = Integer.parseInt(request.getParameter("id"));
        //je recupère la session
        final HttpSession session = request.getSession();
        //je récupère le panier en session et je le remplis
        final PanierDto panierDto = (PanierDto) session.getAttribute(ConnecterUserAction.MON_PANIER);
        iPanierService.deleteProduitPanier(panierDto, idProduit);

        return mapping.findForward("success");
    }
}
