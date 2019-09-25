package presentation.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import presentation.panier.beanDto.PanierDto;
import presentation.users.beanDto.ConnectedUserDto;
import presentation.users.beanDto.ProfilDto;
import presentation.users.beanDto.UserDto;
import presentation.users.form.UserForm;
import service.users.IUserService;
import util.factory.Factory;

/**
 * Action permettant de connecter un user
 * 
 * @author Christian / Catherine
 *
 */
public class CreerUserAction extends Action {

    /**
     * permet de mapper un userForm en userDto
     * 
     * @param userForm
     * @return le UserDto
     */
    private UserDto mapFormToDto(final UserForm userForm) {
        final UserDto userDto = new UserDto();
        userDto.setNom(userForm.getNom());
        userDto.setPrenom(userForm.getPrenom());
        userDto.setDateNaissance(userForm.getDateNaissance());
        userDto.setAdresse(userForm.getAdresse());
        userDto.setPassword(userForm.getPassword());
        userDto.setMail(userForm.getMail());
        userDto.setActif(true);

        final ProfilDto profilDto = new ProfilDto();
        profilDto.setId(Integer.parseInt(userForm.getProfil()));

        userDto.setProfilDto(profilDto);

        return userDto;
    }

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final HttpSession session = request.getSession();
        final UserForm userForm = (UserForm) form;
        final IUserService iUserService = Factory.getInstance(IUserService.class);

        final UserDto userDto = iUserService.createUser(mapFormToDto(userForm));

        if (userDto == null) {
            final ActionErrors errors = new ActionErrors();
            errors.add("error", new ActionMessage("USR_01.errors.creation"));
            saveErrors(request, errors);
            return mapping.findForward("notSuccess");

        } else {
            final ActionMessages messages = new ActionMessages();
            messages.add("creationOK", new ActionMessage("USR_01.creation.ok"));
            saveMessages(request.getSession(), messages);
            final ConnectedUserDto connectedUserDto = iUserService.findUserForConnexion(userForm.getMail(), userForm.getPassword());
            session.setAttribute(ConnecterUserAction.USER_CONNECTED, connectedUserDto);
            final PanierDto panierDto = new PanierDto();
            session.setAttribute(ConnecterUserAction.MON_PANIER, panierDto);
            return mapping.findForward("success");
        }
    }

}
