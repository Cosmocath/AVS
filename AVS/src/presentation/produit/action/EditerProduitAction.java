package presentation.produit.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import presentation.produit.beanDto.ProduitDto;
import presentation.produit.form.ProduitForm;
import service.produit.IProduitService;
import util.factory.Factory;

/**
 * Action permettant de modifier un produit
 * 
 * @author Catherine
 * 
 */
public class EditerProduitAction extends Action {

    /**
     * methode permettant de mapper de produitForm a dto
     * 
     * @param produitForm
     * @return
     */
    private ProduitDto mapToDto(final ProduitForm produitForm) {
        //TODO 1 correspond au no version. il faudra voir comment gerer les non actifs et images
        return ProduitDto.buildProduitDto(Integer.valueOf(produitForm.getIdProduit()), produitForm.getDesignation(), produitForm.getReference(), produitForm.getDescription(), produitForm.getPrix(),
                        produitForm.getImage(), 1, true);
    }

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        // on récupère les infos
        final ProduitForm produitForm = (ProduitForm) form;
        // on récupère les données du Service
        final IProduitService iProduitService = Factory.getInstance(IProduitService.class);
        final ProduitDto produitDto = iProduitService.updateProduit(mapToDto(produitForm));
        // on teste le retour du service
        if (produitDto == null) {
            request.setAttribute("id", Integer.valueOf(produitForm.getIdProduit()));
            final ActionErrors errors = new ActionErrors();
            errors.add("error", new ActionMessage("PDT_03.errors.modification"));
            saveErrors(request, errors);
        } else {
            request.setAttribute("id", produitDto.getId());
            final ActionMessages messages = new ActionMessages();
            messages.add("updateProduitOK", new ActionMessage("PDT_03.editer.ok"));
            saveMessages(request, messages);
        }

        // On redirige 
        return mapping.findForward("success");
    }

}
