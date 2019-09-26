package presentation.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import presentation.users.beanDto.ProfilDto;
import presentation.users.beanDto.UserDto;
import presentation.users.form.EditerUserForm;
import service.users.IUserService;
import util.cryptage.MD5Encryption;
import util.factory.Factory;
import util.tools.Tools;

/**
 * permet d'éditer un user
 * 
 * @author Administrateur
 *
 */
public class EditerUserAction extends Action {

    /**
     * permet de mapper un userForm en userDto
     * 
     * @param userForm
     * @return le UserDto
     */
    private UserDto mapFormToDto(final EditerUserForm editerUserForm) {
        final UserDto userDto = new UserDto();
        userDto.setNom(editerUserForm.getNom());
        userDto.setPrenom(editerUserForm.getPrenom());
        userDto.setDateNaissance(editerUserForm.getDateNaissance());
        userDto.setAdresse(editerUserForm.getAdresse());
        userDto.setMail(editerUserForm.getMail());
        userDto.setActif(true);
        userDto.setId(Integer.valueOf(editerUserForm.getId()));

        final ProfilDto profilDto = new ProfilDto();
        profilDto.setId(Integer.parseInt(editerUserForm.getProfil()));

        if (Tools.isEmpty(editerUserForm.getNewpassword())) {
            userDto.setPassword(editerUserForm.getPassword());
        } else {
            final String newPassword = MD5Encryption.encrypt(editerUserForm.getNewpassword());
            userDto.setPassword(newPassword);
        }

        userDto.setProfilDto(profilDto);

        return userDto;
    }

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        // on récupère les infos
        final EditerUserForm editerUserForm = (EditerUserForm) form;
        // on récupère les données du Service
        final IUserService iUserService = Factory.getInstance(IUserService.class);
        final UserDto userDto = iUserService.updateUser(mapFormToDto(editerUserForm));
        // on teste le retour du service
        if (userDto == null) {
            final ActionErrors errors = new ActionErrors();
            errors.add("error", new ActionMessage("USR_04.errors.modification", new Object[] { editerUserForm.getId() }));
            saveErrors(request, errors);
        } else {
            final ActionMessages messages = new ActionMessages();
            messages.add("updateOK", new ActionMessage("USR_04.editer.ok", new Object[] { userDto.getId() }));
            saveMessages(request, messages);
        }
        return mapping.findForward("success");
    }

}
