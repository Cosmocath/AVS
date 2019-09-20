package service.users.impl;

import persistance.users.beanDo.ProfilDo;
import persistance.users.beanDo.UserDo;
import presentation.users.beanDto.ConnectedUserDto;
import util.enumeration.TypeDeProfil;

/**
 * Mapper Dto/Do bidirectionnel pour un User
 * 
 * @author Administrateur
 *
 */
public class UserMapper {

    /**
     * Permet de mapper un UserDo en UserDto
     * 
     * @param userDo
     * @return
     */
    public static ConnectedUserDto mapToDto(final UserDo userDo) {
        final ConnectedUserDto connectedUserDto = new ConnectedUserDto();
        connectedUserDto.setId(userDo.getId());
        connectedUserDto.setNom(userDo.getNom());
        connectedUserDto.setProfil(mapTypeProfilDoToTypeProfil(userDo.getProfilDo()));
        return connectedUserDto;
    }

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
