package presentation.util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import presentation.users.action.ConnecterUserAction;
import presentation.users.beanDto.ConnectedUserDto;
import service.droit.IDroitService;
import service.users.impl.UserMapper;
import util.enumeration.TypeDeProfil;
import util.factory.Factory;

/**
 * Permet de filtrer les urls selon le profil de l'utilisateur en session
 * 
 * @author Guy-Jöel et Mireille
 *
 */
public class FiltreDroitAcces extends HttpFilter {

    private static final long serialVersionUID = 6800437749061875396L;

    @Override
    public void doFilter(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain) throws IOException, ServletException {
        final HttpSession session = request.getSession();
        final IDroitService iDroitService = Factory.getInstance(IDroitService.class);

        //par défaut le typeDeprofil est visiteur
        TypeDeProfil typeDeProfil = TypeDeProfil.VISITEUR;

        //je prend le profil qui est en session
        if (session.getAttribute(ConnecterUserAction.USER_CONNECTED) != null) {
            final ConnectedUserDto connectedUser = (ConnectedUserDto) session.getAttribute(ConnecterUserAction.USER_CONNECTED);
            typeDeProfil = connectedUser.getProfil();
        }

        //on mappe typeDeProfil en profil string
        final String profil = UserMapper.mapTypeProfilToProfil(typeDeProfil);

        //je recupère l'url en request
        final String url = request.getRequestURI().substring(request.getContextPath().length() + 1);

        try {
            //je contrôle l'accès
            if (!iDroitService.isAcces(url, profil)) {
                //si accès refusé on redirige vers la page de connection
                response.sendRedirect(request.getContextPath() + "/voirConnecterUser.do");
            } else {
                //si accès ok 
                chain.doFilter(request, response);
            }
            // si on recupère une exception pour un lien inconnue on redirige vers la liste des produit
        } catch (final IllegalArgumentException illegalArgumentException) {
            response.sendRedirect(request.getContextPath() + "/listerProduitClient.do");
        }

    }

}
