/**
 * 
 */
package service.users.impl;

import persistance.users.beanDo.ProfilDo;
import persistance.users.dao.IProfilDao;
import presentation.users.beanDto.ProfilDto;
import service.users.IProfilService;
import util.Factory;

/**
 * @author Administrateur
 *
 */
public class ProfilService implements IProfilService {

    @Override
    public ProfilDto findProfilById(final Integer id) {
        final IProfilDao iProfilDao = Factory.getInstance(IProfilDao.class);
        final ProfilDo profilDo = iProfilDao.findProfilById(id);
        return ProfilMapper.mapProfilDoToProfilDto(profilDo);
    }

}
