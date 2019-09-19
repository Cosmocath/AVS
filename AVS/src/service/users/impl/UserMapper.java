package service.users.impl;

import java.util.ArrayList;
import java.util.List;

import persistance.users.beanDo.ProfilDo;
import persistance.users.beanDo.UserDo;
import presentation.users.beanDto.ConnectedUserDto;
import presentation.users.beanDto.UserDto;
import util.TypeDeProfil;

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
     * @return
     */
    public static ConnectedUserDto mapToConnectedUserDto(final UserDo userDo) {
        final ConnectedUserDto connectedUserDto = new ConnectedUserDto();
        connectedUserDto.setId(userDo.getId());
        connectedUserDto.setNom(userDo.getNom());
        connectedUserDto.setProfil(mapTypeProfilDoToTypeProfil(userDo.getProfilDo()));
        return connectedUserDto;
    }

    private static TypeDeProfil mapTypeProfilDoToTypeProfil(final ProfilDo profilDo) {
        switch (profilDo.getNom()) {
            case "admin" :
                return TypeDeProfil.ADMINISTRATEUR;
            case "client" :
                return TypeDeProfil.CLIENT;
            case "visiteur" :
                return TypeDeProfil.VISITEUR;
            default :
                return null;
        }
    }

    /**
     * permet de mapper un userDo en userDto
     * 
     * @param userDo
     * @return
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
        userDto.setProfil(mapTypeProfilDoToTypeProfil(userDo.getProfilDo()));
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
     * Permet de mapper TypeDeProfil en String
     * 
     * @param typeDeProfil
     * @return le profil
     */
    public static String mapTypeProfilToProfil(final TypeDeProfil typeDeProfil) {

        switch (typeDeProfil) {
            case ADMINISTRATEUR :
                return "admin";
            case CLIENT :
                return "client";
            case VISITEUR :
                return "visiteur";
            default :
                return "visiteur";
        }

    }
}
