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
 * @author Administrateur
 *
 */
public class ProfilService implements IProfilService {

    @Override
    public TypeDeProfil findProfilById(final Integer id) {
        final IProfilDao iProfilDao = Factory.getInstance(IProfilDao.class);
        final ProfilDo profilDo = iProfilDao.findProfilById(id);
        return ProfilMapper.mapProfilDoToTypeProfil(profilDo);
    }

}
