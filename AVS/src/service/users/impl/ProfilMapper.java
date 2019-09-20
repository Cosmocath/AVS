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
     * @param profilDto
     * @return
     */
    public static ProfilDo mapProfilDtoToProfilDo(final ProfilDto profilDto) {
        final ProfilDo profilDo = new ProfilDo();
        profilDo.setId(profilDto.getId());
        profilDo.setNom(profilDto.getNom());
        return profilDo;
    }
}
