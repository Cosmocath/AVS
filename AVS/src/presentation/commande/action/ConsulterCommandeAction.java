package presentation.commande.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import service.commande.ICommandeService;
import util.factory.Factory;

/**
 * Action permettant de visualiser le detail d'une commande
 * 
 * @author Valentin
 *
 */
public class ConsulterCommandeAction extends Action{

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final ICommandeService iCommandeService = Factory.getInstance(ICommandeService.class);        
        final Integer idCommande = Integer.valueOf(request.getParameter("idCommande"));
        
        
        return super.execute(mapping, form, request, response);
    }

 

}
