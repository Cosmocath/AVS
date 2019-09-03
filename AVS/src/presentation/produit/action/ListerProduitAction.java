/**
 * 
 */
package presentation.produit.action;

import java.util.ArrayList;
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

/**
 * @author Catherine Hermary
 *
 */
public class ListerProduitAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        // on récupère les données du Service
        final IProduitService iProduitService = Factory.getInstance(IProduitService.class);

        // On recupere la liste de produits depuis la couche Service
        //final List<ProduitDto> listeProduitDto = iProduitService.findAllProduitOrderBy(OrderBy.ASC);

        // TODO je cree une liste fictive pour le test a supprimer apres

        final ProduitDto produitDto = new ProduitDto();
        produitDto.setId(222);
        produitDto.setDesignation("Jardinage");
        produitDto.setPrix(45);
        produitDto.setReference(1212112);
        produitDto.setDescription("Le jardinage est une activité utile pour les jardiniers");

        final ProduitDto produitDto2 = new ProduitDto();
        produitDto2.setId(333);
        produitDto2.setDesignation("Bricolage");
        produitDto2.setPrix(85);
        produitDto2.setReference(5555);
        produitDto2.setDescription("Le bricolage est une activité utile pour les bricoleurs");

        final List<ProduitDto> listeProduitDto = new ArrayList<>();
        listeProduitDto.add(produitDto);
        listeProduitDto.add(produitDto2);

        // mettre la liste à disposition de la vue
        request.setAttribute("listeProduits", listeProduitDto);

        // on va chercher le forward
        return mapping.findForward("success");

    }

}
