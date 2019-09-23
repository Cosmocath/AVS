/**
 * 
 */
package presentation.cgu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import service.cgu.impl.ICGUService;
import util.Factory;

/**
 * @author Administrateur
 *
 */
public class AfficherCGUAction extends Action {
    public static final String PATH_CGU = "C:\\CGU\\testCGU.txt";

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final ICGUService iCGUService = Factory.getInstance(ICGUService.class);
        request.setAttribute("textCGU", iCGUService.afficherCGU());
        return mapping.findForward("success");
    }

}
