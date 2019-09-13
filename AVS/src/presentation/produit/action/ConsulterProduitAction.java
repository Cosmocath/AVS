package presentation.produit.action;

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

        //Instantiation d'un param�tre retour � ajouter dans le html link de la jsp "listerProduitClient" et les 3 autres jsp amenant � PDT_01 afin de le r�cup�rer en getParameter  
        //Instanciation d'un parametre urlRetour � ajouter dans le html link de la jsp "ConsulterProduit" afin de le r�cup�rer en getParameter
        String urlRetour = "";
        String retour = request.getParameter("retour");

        //on teste le parametre retour pour les 4 �crans qu'on veut attendre en cliquant retour
        if (retour.equals("produitClient")) {
            // on r�cup�re l'url de la page d'ou on provient
            urlRetour = "http://localhost:8080/AVS/listerProduitClient.do";
        }
        if (retour.equals("produitAdmin")) {
            urlRetour = "http://localhost:8080/AVS/listerProduitAdmin.do";
        }
        if (retour.equals("panier")) {
            urlRetour = "http://localhost:8080/AVS/consulterPanier.do";
        }
        if (retour.equals("commande")) {
            urlRetour = "http://localhost:8080/AVS/consulterCommande.do";
        }

        // on passe le parametre de l'url en request 
        request.setAttribute("urlRetour", urlRetour);
        // On redirige 
        return mapping.findForward("success");
    }
}
