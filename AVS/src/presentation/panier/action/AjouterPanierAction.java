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
        PanierDto panierDto = (PanierDto) session.getAttribute(ConnecterUserAction.MON_PANIER);
        iPanierService.addProduitPanier(panierDto, idProduit);

        String urlPanier = request.getContextPath();
        final String panier = request.getParameter("panier");
        // je convertis ma chaine retour en une valeur de l enum
        final ParamPanier valeurEnum = ParamPanier.getValue(panier);

        //on teste la valeur de l'enum pour les 4 écrans qu'on veut attendre en cliquant retour
        switch (valeurEnum) {
            case LISTE_PRODUIT_CLIENT :
                // on récupère l'url de la page d'ou on provient
                urlPanier = urlPanier + "/listerProduitClient.do";
                break;

            case PANIER :
                urlPanier = "/consulterPanier.do";
                break;

            case CONSULTER_PRODUIT :
                urlPanier = urlPanier + "/consulterProduit.do";
                break;
        }

        // on passe le parametre de l'url en request 
        request.setAttribute("urlPanier", urlPanier);

        return mapping.findForward("success");
    }
}
