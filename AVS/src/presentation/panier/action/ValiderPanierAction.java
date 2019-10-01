package presentation.panier.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.panier.beanDto.CommandeInfoDto;
import presentation.panier.beanDto.PanierDto;
import presentation.panier.form.PanierForm;
import presentation.users.action.ConnecterUserAction;
import presentation.users.beanDto.ConnectedUserDto;
import service.panier.IPanierService;
import util.factory.Factory;

/**
 * permet de valider le panier
 * 
 * @author Guy-Joël
 *
 */
public class ValiderPanierAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final HttpSession session = request.getSession();
        final PanierForm panierform = (PanierForm) form;
        //je récupère le panier en session
        final PanierDto panierDto = (PanierDto) session.getAttribute(ConnecterUserAction.MON_PANIER);
        //je recupère le profil qui est en session
        final ConnectedUserDto connectedUser = (ConnectedUserDto) session.getAttribute(ConnecterUserAction.USER_CONNECTED);

        // construction du CommandeInfoDto
        final CommandeInfoDto commandeInfoDto = new CommandeInfoDto();
        commandeInfoDto.setAdresseFacturation(panierform.getAdresseFacturation());
        commandeInfoDto.setAdresseLivraison(panierform.getAdresseLivraison());
        commandeInfoDto.setUserId(connectedUser.getId().toString());

        final IPanierService iPanierService = Factory.getInstance(IPanierService.class);
        iPanierService.validerPanier(panierDto, commandeInfoDto);

        return mapping.findForward("success");
    }

}
