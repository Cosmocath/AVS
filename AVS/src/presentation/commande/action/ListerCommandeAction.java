package presentation.commande.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.commande.beanDto.CommandeDto;
import service.commande.ICommandeService;
import util.Factory;

/**
 * Action permettant de visualiser la liste des commandes
 * 
 * @author Administrateur
 *
 */
public class ListerCommandeAction extends Action {

    /**
     *
     */
    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final ICommandeService iCommandeService = Factory.getInstance(ICommandeService.class);
        //TODO revvenir pour paramètre de méthode findAll
        final List<CommandeDto> listeCommandeDto = iCommandeService.findAllCommande(8);
        request.setAttribute("listeCommande", listeCommandeDto);

        return mapping.findForward("success");
    }
}
