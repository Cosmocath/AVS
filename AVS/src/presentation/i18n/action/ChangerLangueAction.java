
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
 * Permet de basculer d'une langue à une autre en fonction du paramètre "langue"
 * 
 * @author Rodolphe
 *
 */
public class ChangerLangueAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        // récupération du paramètre de requête "langue"
        final String langue = request.getParameter("langue");
        // on retourne la langue locale avec le parametre
        final Locale locale = Locale.forLanguageTag(langue);

        request.getSession().setAttribute(Globals.LOCALE_KEY, locale);

        // récupère l'url d'ou l'on provient
        final String urlArrivee = request.getHeader("referer");

        response.sendRedirect(urlArrivee);

        return null;

    }

}
