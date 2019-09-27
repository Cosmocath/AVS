package service.users.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import persistance.users.beanDo.ProfilDo;
import persistance.users.beanDo.UserDo;
import presentation.users.beanDto.ConnectedUserDto;
import presentation.users.beanDto.UserDto;
import util.cryptage.MD5Encryption;
import util.tools.FormatUtil;

/**
 * Mapper Dto/Do bidirectionnel pour un User
 * 
 * @author Administrateur
 *
 */
public class UserMapper {

    /**
     * Permet de mapper un UserDo en ConnectedUserDto
     * 
     * @param userDo
     * @return un userDto connecté
     */
    public static ConnectedUserDto mapToConnectedUserDto(final UserDo userDo) {
        final ConnectedUserDto connectedUserDto = new ConnectedUserDto();
        connectedUserDto.setId(userDo.getId());
        connectedUserDto.setNom(userDo.getNom());
        connectedUserDto.setProfil(ProfilMapper.mapProfilDoToTypeProfil(userDo.getProfilDo()));
        return connectedUserDto;
    }

    /**
     * permet de mapper un userDo en userDto
     * 
     * @param userDo
     * @return un userDto
     */
    public static UserDto mapToDto(final UserDo userDo) {
        final UserDto userDto = new UserDto();
        userDto.setId(userDo.getId());
        userDto.setNom(userDo.getNom());
        userDto.setPrenom(userDo.getPrenom());
        userDto.setDateNaissance(FormatUtil.convertirDateToString(userDo.getDateNaissance()));
        userDto.setAdresse(userDo.getAdresse());
        userDto.setPassword(userDo.getPassword());
        userDto.setMail(userDo.getMail());
        userDto.setActif(userDo.isActif());
        userDto.setProfilDto(ProfilMapper.mapProfilDoToProfilDto(userDo.getProfilDo()));
        return userDto;
    }

    /**
     * permet de mapper une liste de userDo en liste de userDto
     * 
     * @param listeUserDo
     * @return
     */
    public static List<UserDto> mapToListDto(final List<UserDo> listeUserDo) {
        final List<UserDto> listeUserDto = new ArrayList<>();
        for (final UserDo userDo : listeUserDo) {
            listeUserDto.add(mapToDto(userDo));
        }
        return listeUserDto;
    }

    /**
     * permet de mapper le userDto en userDo
     * 
     * @param userDto
     * @return le userDo
     */
    public static UserDo mapToDo(final UserDto userDto) {
        final Date dateNaissance = FormatUtil.convertirStringToDate(userDto.getDateNaissance());
        final ProfilDo profilDo = ProfilMapper.mapProfilDtoToProfilDo(userDto.getProfilDto());
        final String newPassword = MD5Encryption.encrypt(userDto.getPassword());
        final UserDo userDo = UserDo.buildUserDo(userDto.getId(), userDto.getNom(), userDto.getPrenom(), dateNaissance, userDto.getAdresse(), newPassword, profilDo, userDto.getMail(),
                        userDto.isActif());
        return userDo;
    }
}
