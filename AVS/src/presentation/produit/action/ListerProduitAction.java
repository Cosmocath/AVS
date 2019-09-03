/**
 * 
 */
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
 * @author Catherine Hermary
 * 
 *         Classe permettant de créer l'action de lister les produit par ordre alphabétique asc ou desc
 */
public class ListerProduitAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        // on récupère les données du Service
        final IProduitService iProduitService = Factory.getInstance(IProduitService.class);

        // On recupere la liste de produits depuis la couche Service
        final List<ProduitDto> listeProduitDto = iProduitService.findAllProduitOrderBy(OrderBy.ASC);

        // mettre la liste à disposition de la vue
        request.setAttribute("listeProduits", listeProduitDto);

        // on va chercher le forward
        return mapping.findForward("success");
    }
}
