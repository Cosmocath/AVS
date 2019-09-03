
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
 * Permet de basculer d'une langue � une autre en fonction du param�tre "langue"
 * 
 * @author Rodolphe
 *
 */
public class ChangerLangueAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        // r�cup�ration du param�tre de requ�te "langue"
        final String langue = request.getParameter("langue");
        // conversion dans notre enum 
        final Langue enumLangue = Langue.valueOf(langue);
        switch (enumLangue) {
            case FR :
                request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.FRENCH);
                break;
            case EN :
                request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.ENGLISH);
                break;
            default :
                request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.FRENCH);
                break;
        }

        // r�cup�re l'url d'ou l'on provient
        final String urlArrivee = request.getHeader("referer");

        response.sendRedirect(urlArrivee);

        return null;

    }

}