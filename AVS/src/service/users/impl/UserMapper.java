package service.users.impl;

import persistance.users.beanDo.ProfilDo;
import persistance.users.beanDo.UserDo;
import presentation.users.TypeDeProfil;
import presentation.users.beanDto.ConnectedUserDto;

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

        switch (profilDo.getNom()) {
            case "Administrateur" :
                return TypeDeProfil.ADMINISTRATEUR;
            case "Client" :
                return TypeDeProfil.CLIENT;
            case "Visiteur" :
                return TypeDeProfil.VISITEUR;
            default :
                return null;
        }

    }
}
