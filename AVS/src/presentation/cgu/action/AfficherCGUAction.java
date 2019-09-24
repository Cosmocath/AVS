package presentation.cgu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import service.cgu.ICGUService;
import util.factory.Factory;

/**
 * action permettant d'afficher les CGU
 * 
 * @author Administrateur
 *
 */
public class AfficherCGUAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final ICGUService iCGUService = Factory.getInstance(ICGUService.class);
        response.getWriter().write(iCGUService.afficherCGU());
        response.getWriter().flush();
        return null;
    }

}
