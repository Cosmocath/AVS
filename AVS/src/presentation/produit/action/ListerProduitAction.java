package presentation.produit.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.produit.beanDto.ProduitDto;
import service.produit.IProduitService;
import util.Factory;
import util.OrderBy;

/**
 * Classe permettant de cr�er l'action de lister les produit par ordre alphab�tique asc ou desc
 * 
 * @author Catherine Hermary
 * 
 */
public class ListerProduitAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        // on r�cup�re les donn�es du Service
        final IProduitService iProduitService = Factory.getInstance(IProduitService.class);

        // on recup�re le param�tre de la request et on le cast

        String paramOrderBy = request.getParameter("orderBy");
        OrderBy enumOrderBy = OrderBy.ASC;

        if (paramOrderBy != null && !"".equals(paramOrderBy)) {
            // on le convertit en enum
            enumOrderBy = OrderBy.valueOf(paramOrderBy);

        }
        
        // on appelle la methode
        final List<ProduitDto> listeProduitDto = iProduitService.findAllProduitOrderBy(enumOrderBy);
        
        // si la methode a fonctionn� en mode ascendant, alors on passe le parametre descendant en requete, et vice versa
        if (enumOrderBy == OrderBy.ASC) {
            request.setAttribute("TRI", OrderBy.DESC);
        } else {
            request.setAttribute("TRI", OrderBy.ASC);
        }

        // mettre la liste � disposition de la vue
        request.setAttribute("listeProduits", listeProduitDto);


        // on va chercher le forward
        return mapping.findForward("success");
    }
}
