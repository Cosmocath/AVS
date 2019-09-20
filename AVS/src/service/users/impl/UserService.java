package service.users.impl;

import java.util.List;

import persistance.users.beanDo.UserDo;
import persistance.users.dao.IUserDao;
import presentation.users.beanDto.ConnectedUserDto;
import presentation.users.beanDto.UserDto;
import service.users.IUserService;
import util.enumeration.OrderBy;
import util.factory.Factory;

/**
 * 
 * Implémentation du service pour gérer les users
 * 
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
        return UserMapper.mapToConnectedUserDto(userDo);
    }

    @Override
    public List<UserDto> findAllUserOrderBy(final OrderBy orderBy) {
        final IUserDao iUserDao = Factory.getInstance(IUserDao.class);
        final List<UserDo> listeUserDo = iUserDao.findAllUserOrderBy(orderBy);
        return UserMapper.mapToListDto(listeUserDo);
    }
}
