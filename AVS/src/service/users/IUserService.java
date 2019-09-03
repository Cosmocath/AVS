package service.users;

import presentation.users.beanDto.ConnectedUserDto;

public interface IUserService {

  
    /**
     * @param mail
     * @param password
     * @return
     */
    ConnectedUserDto findUserForConnexion(final String mail, final String password);

}
