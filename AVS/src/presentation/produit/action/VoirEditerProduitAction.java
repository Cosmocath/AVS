/**
 * 
 */
package presentation.produit.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.produit.beanDto.ProduitDto;
import presentation.produit.form.ProduitForm;
import service.produit.IProduitService;
import util.factory.Factory;

/**
 * Action permettant d'aller à la page de modification d'un produit
 * 
 * @author Catherine
 *
 */
public class VoirEditerProduitAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        // on recupère le paramètre de la request (ou en attribut)

        final int idProduitDto;

        if (request.getParameter("id") != null) {
            idProduitDto = Integer.parseInt(request.getParameter("id"));
        } else {
            idProduitDto = (Integer) request.getAttribute("id");
        }

        // on récupère les données du Service
        final IProduitService iProduitService = Factory.getInstance(IProduitService.class);
        final ProduitDto produitDto = iProduitService.getProduitById(idProduitDto);
        // on les met à disposition de la vue, avec le même nom que le formulaire dans le struts config
        final ProduitForm produitForm = mapToProduitForm(produitDto);
        request.setAttribute("produitForm", produitForm);
        // On redirige 
        return mapping.findForward("success");
    }

    public ProduitForm mapToProduitForm(final ProduitDto produitDto) {
        final ProduitForm produitForm = new ProduitForm();
        produitForm.setIdProduit(String.valueOf(produitDto.getId()));
        produitForm.setDesignation(produitDto.getDesignation());
        produitForm.setReference(produitDto.getReference());
        produitForm.setDescription(produitDto.getDescription());
        produitForm.setPrix(produitDto.getPrix());
        return produitForm;
    }

}
