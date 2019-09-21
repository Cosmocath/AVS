package service.users.impl;

import java.util.ArrayList;
import java.util.List;

import persistance.users.beanDo.UserDo;
import presentation.users.beanDto.ConnectedUserDto;
import presentation.users.beanDto.UserDto;

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
        userDto.setDateNaissance(userDo.getDateNaissance());
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
        final UserDo userDo = new UserDo();
        userDo.setId(userDto.getId());
        userDo.setNom(userDto.getNom());
        userDo.setPrenom(userDto.getPrenom());
        userDo.setDateNaissance(userDto.getDateNaissance());
        userDo.setAdresse(userDto.getAdresse());
        userDo.setPassword(userDto.getPassword());
        userDo.setMail(userDto.getMail());
        userDo.setActif(userDto.isActif());
        userDo.setProfilDo(ProfilMapper.mapProfilDtoToProfilDo(userDto.getProfilDto()));
        return userDo;
    }
}
