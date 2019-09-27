package presentation.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.users.beanDto.UserDto;
import presentation.users.form.EditerUserForm;
import service.users.IUserService;
import util.factory.Factory;

/**
 * Action permettant d'aller à la page de modification d'un user
 * 
 * @author Administrateur
 *
 */
public class VoirEditerUserAction extends Action {

    private EditerUserForm mapToEditerUserForm(final UserDto userDto) {
        final EditerUserForm editerUserForm = new EditerUserForm();
        editerUserForm.setAdresse(userDto.getAdresse());
        editerUserForm.setNom(userDto.getNom());
        editerUserForm.setPrenom(userDto.getPrenom());
        editerUserForm.setDateNaissance(userDto.getDateNaissance());
        editerUserForm.setMail(userDto.getMail());
        editerUserForm.setId(userDto.getId().toString());
        editerUserForm.setPassword(userDto.getPassword());
        editerUserForm.setProfil(String.valueOf(userDto.getProfilDto().getId()));
        return editerUserForm;
    }

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        // on recupère le paramètre de la request
        final int idUser = Integer.parseInt(request.getParameter("id"));
        // on récupère les données du Service
        final IUserService iUserService = Factory.getInstance(IUserService.class);
        final UserDto userDto = iUserService.findUserDto(idUser);
        // on les met à disposition de la vue, avec le même nom que le formulaire dans le struts config
        request.setAttribute("editerUserForm", mapToEditerUserForm(userDto));
        return mapping.findForward("success");
    }

}
