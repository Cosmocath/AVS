/**
 * 
 */
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
 * Permet de diminuer la quantit� d'un produit dans le panier
 * 
 * @author Administrateur
 *
 */
public class DiminuerQteAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        //je recup�re la session
        HttpSession session = request.getSession();
        //je recup�re le panier dans la session
        final PanierDto panierDto = (PanierDto) session.getAttribute(ConnecterUserAction.MON_PANIER);
        //je recup�re l'idProduit en param�tre
        final Integer idProduit = Integer.parseInt(request.getParameter("id"));
        //je cr�e une instance de iPanierService
        final IPanierService iPanierService = Factory.getInstance(IPanierService.class);
        //je diminue la quantit� de produit
        iPanierService.diminuerProduitPanier(panierDto, idProduit);

        //je retourne la redirection
        return mapping.findForward("pan_00");
    }

}
