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
import service.panier.IPanierService;
import util.enumeration.ParamPanier;
import util.factory.Factory;

/**
 * Permet d'ajouter le produit au panier en session
 * 
 * @author Nora LIFERKI
 *
 */
public class AjouterPanierAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final IPanierService iPanierService = Factory.getInstance(IPanierService.class);

        final Integer idProduit = Integer.parseInt(request.getParameter("id"));
        //je recupère la session
        final HttpSession session = request.getSession();
        //je récupère le panier en session et je le remplis
        final PanierDto panierDto = (PanierDto) session.getAttribute(ConnecterUserAction.MON_PANIER);
        iPanierService.addProduitPanier(panierDto, idProduit);

        //message panier vide
        if (panierDto == null) {
            final ActionMessages messages = new ActionMessages();
            messages.add("panierVide", new ActionMessage("panier Vide"));
            saveMessages(request, messages);
        }
        //

        final String retour = request.getParameter("retour");
        // je convertis ma chaine retour en une valeur de l enum
        final ParamPanier valeurEnum = ParamPanier.getValue(retour);

        //on teste la valeur de l'enum pour les 4 écrans qu'on veut attendre en cliquant retour
        switch (valeurEnum) {
            case LISTE_PRODUIT_CLIENT :
                return mapping.findForward("pdt_00");
            case CONSULTER_PRODUIT :
                return mapping.findForward("pdt_01");
            case PANIER :
                return mapping.findForward("pan_00");
        }

        return mapping.findForward("success");
    }
}
