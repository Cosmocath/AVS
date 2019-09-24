package presentation.image.action;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import service.image.IImageService;
import util.factory.Factory;

/**
 * Permet d'afficher une image dans une jsp
 * 
 * @author Rodolphe
 *
 */
public class AfficherImageAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("toto");
        //on met l'idImageDto  en paramètre
        final String urlImage = request.getParameter("urlImage");
        System.out.println("image :" + urlImage);

        //accès à la couche service
        final IImageService iImageService = Factory.getInstance(IImageService.class);

        response.setContentType("image/jpg");
        OutputStream os = response.getOutputStream();

        //je stocke le flux d'octet  
        byte[] btImg = iImageService.getImage(urlImage);

        //dans le flux de sortie de response j'ecris le tableau de byte
        os.write(btImg);

        //j'envoie l'ordre d'instruction de lecture
        os.flush();

        //je fermer le flux
        os.close();

        //on retourne la redirection
        return mapping.findForward("success");

    }

}
