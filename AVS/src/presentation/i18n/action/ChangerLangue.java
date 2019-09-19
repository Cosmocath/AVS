package presentation.i18n.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Action permettant de basculer d'une langue à l'autre
 * 
 * @author Rodolphe
 *
 */
public class ChangerLangue extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final String langue = request.getParameter("langue");
        switch (langue) {
            case "fr" :
                request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.FRENCH);
                break;
            case "en" :
                request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.ENGLISH);
                break;
            default :
                request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.FRENCH);
                break;
        }

        // récupère l'url d'ou l'on provient
        final String urlArrivee = request.getHeader("referer");

        response.sendRedirect(urlArrivee);

        return null;

    }

}
