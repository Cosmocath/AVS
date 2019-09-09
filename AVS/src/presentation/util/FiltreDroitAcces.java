package presentation.util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import presentation.users.action.ConnecterUserAction;
import service.droit.IDroitService;
import util.Factory;

/**
 * @author Guy-Jöel et Mireille
 *
 */
public class FiltreDroitAcces extends HttpFilter {

    private static final long serialVersionUID = 6800437749061875396L;

    /**
     * filtre les accès aux url
     */
    @Override
    public void doFilter(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain) throws IOException, ServletException {
        final HttpSession session = request.getSession();
        final IDroitService iDroitService = Factory.getInstance(IDroitService.class);

        //je prend le profil qui est en session
        String profil = "";

        if (session.getAttribute(ConnecterUserAction.USER_CONNECTED) == null) {
            profil = "visiteur";
        } else {
            profil = (String) session.getAttribute(ConnecterUserAction.USER_CONNECTED);
        }

        //je recupère l'url en request
        final String url = request.getRequestURI().substring(request.getContextPath().length() + 1);

        //je contrôle l'accès
        if (!iDroitService.isAcces(url, profil)) {
            //si accès refusé on redirige vers la page de connection
            response.sendRedirect(request.getContextPath() + "/voirConnecterUser.do");
        } else {
            //si accès ok 
            chain.doFilter(request, response);

        }

    }

}
