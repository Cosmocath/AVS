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
import util.ConversionUtil;
import util.factory.Factory;

/**
 * Action permettant de cr�er un produit
 * 
 * @author Rodolphe
 *
 */
public class CreerProduitAction extends Action {
    /**
     * Permet de mapper un form en produit
     * 
     * @param produitForm
     * @return
     */
    private ProduitDto mapToDto(final ProduitForm produitForm) {
        return ProduitDto.build(produitForm.getDesignation(), produitForm.getReference(), produitForm.getDescription(), ConversionUtil.convertDoubleCommaToDot(produitForm.getPrix()),
                        produitForm.getImage(), 1);
    }

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        // on r�cup�re les infos
        final ProduitForm produitForm = (ProduitForm) form;
        // on r�cup�re les donn�es du Service
        final IProduitService iProduitService = Factory.getInstance(IProduitService.class);
        final ProduitDto produitDto = iProduitService.create(mapToDto(produitForm));
        // on teste le retour du service
        if (produitDto == null) {
            final ActionErrors errors = new ActionErrors();
            errors.add("error", new ActionMessage("PDT_02.error.creation", new Object[] { produitForm.getReference() }));
            saveErrors(request, errors);
        } else {
            final ActionMessages messages = new ActionMessages();
            messages.add("creationProduitOK", new ActionMessage("PDT_02.valid.ok"));
            saveMessages(request, messages);
        }
        return mapping.findForward("success");
    }

}
