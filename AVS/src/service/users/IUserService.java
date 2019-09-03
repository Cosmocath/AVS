package service.users;

import presentation.users.beanDto.ConnectedUserDto;

/**
 * Interface permettant de d�clarer les m�thodes du business service UserService
 * 
 * @author Administrateur
 *
 */
public interface IUserService {

    /**
     * Permet de faire appel � la couche persistance afin de rechercher un user en BDD � partir de son mail et de son password
     * 
     * @param mail
     * @param password
     * @return
     */
    ConnectedUserDto findUserForConnexion(final String mail, final String password);

}
