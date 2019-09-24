package service.users;

import java.util.List;

import presentation.users.beanDto.ConnectedUserDto;
import presentation.users.beanDto.UserDto;
import util.enumeration.OrderBy;

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
     * permet de faire appel a la couche persistance afin de rechercher tous les users stockés en BDD Méthode permettant de trier la liste par ordre alphabétique asc ou desc
     * 
     * @param enum {@link OrderBy} asc ou desc
     * @return la liste des users par ordre alphabétique
     */
    List<UserDto> findAllUserOrderBy(final OrderBy orderBy);

    /**
     * Permet de faire appel à la couche persistance afin de rechercher un user en BDD à partir de son id
     * 
     * @param id
     * @return un userDto s'il existe sinon null
     */
    UserDto findUserDto(final Integer id);

    /**
     * Permet de faire appel à la couche persistance afin de rechercher un user en BDD à partir de son mail**
     * 
     * @param mail
     * @return un UserDto du user rechérché,null si non trouvé
     */
    UserDto findUserByMail(final String mail);

    /**
     * Permet de faire appel à la couche persistance afin de créer un user en BDD
     * 
     * @param userDto
     * @return le UserDto crée
     */
    UserDto createUser(final UserDto userDto);
}
