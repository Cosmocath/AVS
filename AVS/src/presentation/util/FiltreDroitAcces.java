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
import service.users.impl.UserMapper;
import util.Factory;
import util.TypeDeProfil;

/**
 * @author Guy-J�el et Mireille
 *
 */
public class FiltreDroitAcces extends HttpFilter {

    private static final long serialVersionUID = 6800437749061875396L;

    /**
     * filtre les acc�s aux url
     */
    @Override
    public void doFilter(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain) throws IOException, ServletException {
        final HttpSession session = request.getSession();
        final IDroitService iDroitService = Factory.getInstance(IDroitService.class);

        //par d�faut le typeDeprofil est visiteur
        TypeDeProfil typeDeProfil = TypeDeProfil.VISITEUR;

      //je prend le profil qui est en session
        if (session.getAttribute(ConnecterUserAction.USER_CONNECTED) != null) {
            typeDeProfil = (TypeDeProfil) session.getAttribute(ConnecterUserAction.USER_CONNECTED);
        }
        //on mappe typeDeProfil en profil string
        final String profil = UserMapper.mapTypeProfilToProfil(typeDeProfil);

        //je recup�re l'url en request
        final String url = request.getRequestURI().substring(request.getContextPath().length() + 1);

        //je contr�le l'acc�s
        if (!iDroitService.isAcces(url, profil)) {
            //si acc�s refus� on redirige vers la page de connection
            response.sendRedirect(request.getContextPath() + "/voirConnecterUser.do");
        } else {
            //si acc�s ok 
            chain.doFilter(request, response);

        }

    }

}
