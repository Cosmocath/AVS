/**
 * 
 */
package presentation.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.util.MapFactory;

/**
 * @author Administrateur
 *
 */
public class FiltreDroitAcces implements Filter {

    /**
     * permet de verifier si le profil a accès à l'url
     * 
     * @param profil à tester
     * @param listeNomProfil ayant accès à l'url
     * @return true si Accès ok, sinon false
     */
    private boolean isAcces(final String profil, final List<String> listeNomProfil) {
        for (final String nomProfil : listeNomProfil) {
            if (profil.equals(nomProfil)) {
                return true;
            }

        }

        return false;

    }

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse rep, final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) rep;
        final HttpSession session = request.getSession(false);

        //je prend le profil qui est en session
        String profil = "";

        if (session == null) {
            profil = "visiteur";
        } else {
            profil = (String) session.getAttribute("user");
        }

        //je recupère l'url en request
        final String url = request.getRequestURI().substring(request.getContextPath().length() + 1);

        //on recupère la liste des profils
        final List<String> listeProfils = MapFactory.getMap().get(url);

        //je contrôle l'accès
        if (!isAcces(profil, listeProfils)) {
            //si accès refusé on redirige vers la page de connection
            response.sendRedirect(request.getContextPath() + "/voirConnecterUser.do");
        } else {
            //si accès ok 
            chain.doFilter(request, response);

        }

    }

}
