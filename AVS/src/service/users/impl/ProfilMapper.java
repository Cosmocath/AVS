/**
 * 
 */
package service.users.impl;

import persistance.users.beanDo.ProfilDo;
import persistance.users.dao.IProfilDao;
import service.users.IProfilService;
import util.Factory;
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
}
