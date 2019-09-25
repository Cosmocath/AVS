package presentation.panier.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.panier.beanDto.PanierDto;
import presentation.produit.beanDto.ProduitDto;
import presentation.users.action.ConnecterUserAction;
import service.produit.IProduitService;
import util.factory.Factory;

/**
 * Permet d'afficher le panierDto de la session
 * 
 * @author Administrateur
 *
 */
public class VoirPanierAction extends Action {

    /**
     * Iniatalise un panier virtuel TODO a supprimer après réalisation du bouton ajouter
     * 
     * @return panierDto initialisé
     */
    public PanierDto initPanierDto(final PanierDto panierDto) {
        final IProduitService iProduitService = Factory.getInstance(IProduitService.class);
        final ProduitDto produitDto = iProduitService.getProduitById(12);
        panierDto.getMapDesProduitsQte().put(produitDto, 3);

        final ProduitDto produitDto1 = iProduitService.getProduitById(14);
        panierDto.getMapDesProduitsQte().put(produitDto1, 22);

        panierDto.setTotalAvantRemise(210.00);
        panierDto.setRemise(42.00);
        panierDto.setTotalApresRemise(251.00);
        panierDto.setQuantiteTotale(200);
        return panierDto;

    }

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        //je recupère la session
        final HttpSession session = request.getSession();
        //je récupère le panier en session et je l'initialise
        final PanierDto panierDto = (PanierDto) session.getAttribute(ConnecterUserAction.MON_PANIER);
        //j'initialise le panierDto
        initPanierDto(panierDto);
        //j'initialise l'affichage du nombre de produit
        return mapping.findForward("success");
    }

}
