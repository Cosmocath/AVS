package presentation.produit.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.produit.beanDto.ProduitDto;
import service.produit.IProduitService;
import util.factory.Factory;

/**
 * Action permettant de consulter un produit
 * 
 * @author Nora LIFERKI
 *
 */
public class ConsulterProduitAction extends Action {

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final Integer idProduit = Integer.parseInt(request.getParameter("id"));
        final IProduitService iProduitService = Factory.getInstance(IProduitService.class);
        final ProduitDto produitDto = iProduitService.getProduitById(idProduit);
        request.setAttribute("produit", produitDto);

        //Instantiation d'un paramètre retour à ajouter dans le html link de la jsp "listerProduitClient" et les 3 autres jsp amenant à PDT_01 afin de le récupérer en getParameter  
        //Instanciation d'un parametre urlRetour à ajouter dans le html link de la jsp "ConsulterProduit" afin de le récupérer en getParameter
        String urlRetour = "http://localhost:8080/AVS/";
        final String retour = request.getParameter("retour");

        //on teste le parametre retour pour les 4 écrans qu'on veut attendre en cliquant retour
        switch (retour) {
            case "produitClient" :
                // on récupère l'url de la page d'ou on provient
                urlRetour = urlRetour + "listerProduitClient.do";
                break;

            case "produitAdmin" :
                urlRetour = urlRetour + "listerProduitAdmin.do";
                break;

            case "panier" :
                urlRetour = "consulterPanier.do";
                break;

            case "commande" :
                urlRetour = urlRetour + "consulterCommande.do";
                break;
        }

        // on passe le parametre de l'url en request 
        request.setAttribute("urlRetour", urlRetour);
        // On redirige 
        return mapping.findForward("success");
    }
}
