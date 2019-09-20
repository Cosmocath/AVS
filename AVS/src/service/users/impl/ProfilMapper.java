/**
 * 
 */
package service.users.impl;

import persistance.users.beanDo.ProfilDo;
import presentation.users.beanDto.ProfilDto;
import util.TypeDeProfil;

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
