package service.users.impl;

import java.util.ArrayList;
import java.util.List;

import persistance.users.beanDo.ProfilDo;
import persistance.users.beanDo.UserDo;
import presentation.users.beanDto.ConnectedUserDto;
import presentation.users.beanDto.UserDto;
import util.enumeration.TypeDeProfil;

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
     * @return un userDto connect�
     */
    public static ConnectedUserDto mapToConnectedUserDto(final UserDo userDo) {
        final ConnectedUserDto connectedUserDto = new ConnectedUserDto();
        connectedUserDto.setId(userDo.getId());
        connectedUserDto.setNom(userDo.getNom());
        connectedUserDto.setProfil(mapTypeProfilDoToTypeProfil(userDo.getProfilDo()));
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
     * Permet de mapper un profil en TypeDeProfil
     * 
     * @param profilDo
     * @return la valeur de l'enum TypeDeProfil
     */
    private static TypeDeProfil mapTypeProfilDoToTypeProfil(final ProfilDo profilDo) {
        return TypeDeProfil.getValue(profilDo.getNom());
    }

    /**
     * Permet de mapper TypeDeProfil en String
     * 
     * @param typeDeProfil
     * @return le profil
     */
    public static String mapTypeProfilToProfil(final TypeDeProfil typeDeProfil) {
        return typeDeProfil.getNomBD();
    }
}
