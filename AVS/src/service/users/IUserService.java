package service.users;

import java.util.List;

import presentation.users.beanDto.ConnectedUserDto;
import presentation.users.beanDto.UserDto;

/**
 * Interface permettant de déclarer les méthodes du business service UserService
 * 
 * @author Administrateur
 *
 */
public interface IUserService {

    /**
     * Permet de faire appel à la couche persistance afin de rechercher un user en BDD à partir de son mail et de son password
     * 
     * @param mail
     * @param password
     * @return un ConnectedUserDto du user rechérché, null si non trouvé
     */
    ConnectedUserDto findUserForConnexion(final String mail, final String password);

    /**
     * permet de faire appel a la couche persistance afin de rechercher tous les users stockés en BDD
     * 
     * @return la liste de tous les user stockés en BDD
     */
    List<UserDto> findAllUserDto();
}
