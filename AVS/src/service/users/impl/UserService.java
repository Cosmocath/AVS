
/**
 * 
 */
package service.users.impl;

import persistance.users.beanDo.UserDo;
import persistance.users.dao.impl.IUserDao;
import presentation.users.beanDto.ConnectedUserDto;
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
        return UserMapper.mapToDto(userDo);
    }

}
