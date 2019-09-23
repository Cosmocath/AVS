package presentation.produit.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.produit.beanDto.ProduitDto;
import service.produit.IProduitService;
import util.enumeration.ParamRetour;
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

        //Instantiation d'un param�tre retour � ajouter dans le html link de la jsp "listerProduitClient" et les 3 autres jsp amenant � PDT_01 afin de le r�cup�rer en getParameter  
        //Instanciation d'un parametre urlRetour � ajouter dans le html link de la jsp "ConsulterProduit" afin de le r�cup�rer en getParameter
        //String urlRetour = "http://localhost:8080/AVS/";
        String urlRetour= request.getContextPath();
        final String retour = request.getParameter("retour");
        // je convertis ma chaine retour en une valeur de l enum
        final ParamRetour valeurEnum= ParamRetour.getValue(retour); 
        
        //on teste la valeur de l'enum pour les 4 �crans qu'on veut attendre en cliquant retour
        switch (valeurEnum) {
            case PRODUIT_CLIENT :
                // on r�cup�re l'url de la page d'ou on provient
                urlRetour = urlRetour + "/listerProduitClient.do";
                break;

            case PRODUIT_ADMIN :
                urlRetour = urlRetour + "/listerProduitAdmin.do";
                break;

            case PANIER :
                urlRetour = "/consulterPanier.do";
                break;

            case COMMANDE :
                urlRetour = urlRetour + "/consulterCommande.do";
                break;
        }

        // on passe le parametre de l'url en request 
        request.setAttribute("urlRetour", urlRetour);
        // On redirige 
        return mapping.findForward("success");
    }
}
