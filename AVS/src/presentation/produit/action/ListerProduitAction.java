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

public class ListerProduitAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // on r�cup�re les donn�es du Service
        final IProduitService iProduitService = Factory.getInstance(IProduitService.class);
        // TODO mapper liste produitDo en listeProduitDto et continuer la methode
        final List<ProduitDto> listeProduitDto = new ArrayList<>();

        // mettre la liste � disposition de la vue
        request.setAttribute("listeProduit", listeProduitDto);

        // on va chercher le forward
        return mapping.findForward("success");

    }

}
