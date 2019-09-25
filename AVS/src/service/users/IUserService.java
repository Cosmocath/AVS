package service.users;

import java.util.List;

import presentation.users.beanDto.ConnectedUserDto;
import presentation.users.beanDto.UserDto;
import util.enumeration.OrderBy;

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
     * permet de faire appel a la couche persistance afin de rechercher tous les users stock�s en BDD M�thode permettant de trier la liste par ordre alphab�tique asc ou desc
     * 
     * @param enum {@link OrderBy} asc ou desc
     * @return la liste des users par ordre alphab�tique
     */
    List<UserDto> findAllUserOrderBy(final OrderBy orderBy);

    /**
     * Permet de faire appel � la couche persistance afin de rechercher un user en BDD � partir de son id
     * 
     * @param id
     * @return un userDto s'il existe sinon null
     */
    UserDto findUserDto(final Integer id);

    /**
     * Permet de faire appel � la couche persistance afin de rechercher un user en BDD � partir de son mail**
     * 
     * @param mail
     * @return un UserDto du user rech�rch�,null si non trouv�
     */
    UserDto findUserByMail(final String mail);

    /**
     * Permet de faire appel � la couche persistance afin de cr�er un user en BDD
     * 
     * @param userDto
     * @return le UserDto cr�e
     */
    UserDto createUser(final UserDto userDto);
}
