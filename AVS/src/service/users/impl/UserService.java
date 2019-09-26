package service.users.impl;

import java.util.List;

import persistance.users.beanDo.UserDo;
import persistance.users.dao.IUserDao;
import presentation.users.beanDto.ConnectedUserDto;
import presentation.users.beanDto.ProfilDto;
import presentation.users.beanDto.UserDto;
import service.users.IProfilService;
import service.users.IUserService;
import util.cryptage.MD5Encryption;
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
        // Je crypte le password passé par l utilisateur
        final String cryptPassword = MD5Encryption.encrypt(password);
        final UserDo userDo = iUserDao.findUserForConnexion(mail, cryptPassword);
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

    @Override
    public UserDto findUserDto(final Integer id) {
        final IUserDao iUserDao = Factory.getInstance(IUserDao.class);
        final UserDo userDo = iUserDao.findUserDo(id);
        return UserMapper.mapToDto(userDo);
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

        // recuperer le password passé dans le formulaire
        final String password = userDto.getPassword();
        // le crypter
        final String cryptPassword = MD5Encryption.encrypt(password);
        // le lier au userDto
        userDto.setPassword(cryptPassword);

        userDto.setProfilDto(profilDto);

        iUserDao.createUser(UserMapper.mapToDo(userDto));
        return userDto;

    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        final IUserDao iUserDao = Factory.getInstance(IUserDao.class);
        // on recherche d'abord si on a le droit de modifier le numero de puce !
        UserDo userDo = iUserDao.findUserDo(userDto.getId());
        // soit il n'y a pas de chat avec ce n° de puce, soit c'est le même chat
        if (userDo == null || userDo.getId() == userDto.getId()) {
            userDo = iUserDao.updateUserDo(userDto.getId(), UserMapper.mapToDo(userDto));
            return UserMapper.mapToDto(userDo);
        }
        return null;
    }
}
