package service.users;

import java.util.List;

import presentation.users.beanDto.ConnectedUserDto;
import presentation.users.beanDto.UserDto;

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
     * @return un ConnectedUserDto du user rech�rch�, null si non trouv�
     */
    ConnectedUserDto findUserForConnexion(final String mail, final String password);

    /**
     * permet de faire appel a la couche persistance afin de rechercher tous les users stock�s en BDD
     * 
     * @return la liste de tous les user stock�s en BDD
     */
    List<UserDto> findAllUserDto();
}
