package service.users.impl;

import persistance.users.beanDo.ProfilDo;
import presentation.users.beanDto.ProfilDto;
import util.enumeration.TypeDeProfil;

/**
 * Mapper Dto/Do bidirectionnel pour un Profil + TypeDeProfil
 * 
 * @author Administrator
 *
 */
public class ProfilMapper {

    /**
     * Permet de mapper un profil en TypeDeProfil
     * 
     * @param profilDo
     * @return la valeur de l'enum TypeDeProfil
     */
    public static TypeDeProfil mapProfilDoToTypeProfil(final ProfilDo profilDo) {
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

    /**
     * Permet de mapper ProfilDo en ProfilDto
     * 
     * @param profilDo
     * @return le profilDto
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
