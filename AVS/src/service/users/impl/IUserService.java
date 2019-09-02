package service.users.impl;

import presentation.users.beanDto.ConnectedUserDto;

public interface IUserService {

    /**
     * @param mail
     * @param pwd
     * @return
     */
    ConnectedUserDto findUserForConnexion(final String mail, final String password);

}
