package service.users.impl;

import java.util.List;

import persistance.users.beanDo.UserDo;
import persistance.users.dao.IUserDao;
import presentation.users.beanDto.ConnectedUserDto;
import presentation.users.beanDto.ProfilDto;
import presentation.users.beanDto.UserDto;
import service.users.IProfilService;
import service.users.IUserService;
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
    public List<UserDto> findAllUserDto() {
        final IUserDao iUserDao = Factory.getInstance(IUserDao.class);
        // on pourrait ne pas utiliser cette variable
        final List<UserDo> listeUserDo = iUserDao.findAllUserDo();
        return UserMapper.mapToListDto(listeUserDo);
    }

    @Override
    public UserDto findUserByMail(final String mail) {
        final IUserDao iUserDao = Factory.getInstance(IUserDao.class);
        final UserDo userDo = iUserDao.findUserByMail(mail);

        if (userDo == null) {
            return null;
        }

        return UserMapper.mapToDto(userDo);
    }

    @Override
    public UserDto createUser(final UserDto userDto) {
        final IUserDao iUserDao = Factory.getInstance(IUserDao.class);
        if (this.findUserByMail(userDto.getMail()) != null) {
            return null;
        }

        final IProfilService iProfilService = Factory.getInstance(IProfilService.class);
        final ProfilDto profilDto = iProfilService.findProfilById(userDto.getProfilDto().getId());
        userDto.setProfilDto(profilDto);

        iUserDao.createUser(UserMapper.mapToDo(userDto));
        return userDto;

    }
}
