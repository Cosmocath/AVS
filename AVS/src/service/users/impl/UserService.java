
/**
 * 
 */
package service.users.impl;

import persistance.users.beanDo.UserDo;
import persistance.users.dao.IUserDao;
import presentation.users.beanDto.ConnectedUserDto;
import service.users.IUserService;
import util.Factory;

/**
 * @author Administrateur
 *
 */
public class UserService implements IUserService {

    private UserService() {

        // empty constructor
    }

    @Override
    public ConnectedUserDto findUserForConnexion(final String mail, final String password) {
        final IUserDao iUserDao = Factory.getInstance(IUserDao.class);
        final UserDo userDo = iUserDao.findUserForConnexion(mail, password);
        if (userDo == null || !userDo.isActif()) {
            return null;
        }
        return UserMapper.mapToDto(userDo);
    }

}
