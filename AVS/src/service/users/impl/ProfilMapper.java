/**
 * 
 */
package service.users.impl;

import persistance.users.beanDo.ProfilDo;
import presentation.users.beanDto.ProfilDto;
import util.enumeration.TypeDeProfil;

/**
 * @author Administrator
 *
 */
public class ProfilMapper {

    /**
     * @param profilDo
     * @return
     */
    public static TypeDeProfil mapProfilDoToTypeProfil(final ProfilDo profilDo) {

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

    /**
     * Permet de mapper ProfilDo en ProfilDto
     * 
     * @param profilDo
     * @return
     */
    public static ProfilDto mapProfilDoToProfilDto(final ProfilDo profilDo) {
        final ProfilDto profilDto = new ProfilDto();
        profilDto.setId(profilDo.getId());
        profilDto.setNom(profilDo.getNom());
        return profilDto;
    }

    /**
     * Permet de mapper ProfilDto en ProfilDo
     * 
     * @param profilDto
     * @return le profilDo
     */
    public static ProfilDo mapProfilDtoToProfilDo(final ProfilDto profilDto) {
        final ProfilDo profilDo = new ProfilDo();
        profilDo.setId(profilDto.getId());
        profilDo.setNom(profilDto.getNom());
        return profilDo;
    }
}
