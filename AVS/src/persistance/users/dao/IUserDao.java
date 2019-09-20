package persistance.users.dao;

import java.util.List;

import persistance.users.beanDo.UserDo;
import util.enumeration.OrderBy;

/**
 * Interface de UserDao
 * 
 * @author Administrateur
 *
 */
public interface IUserDao {

    /**
     * Permer de rechercher un user selon son mail et son mot de passe
     * 
     * @param mail
     * @param password
     * @return le user recherch�, null sinon
     */
    UserDo findUserForConnexion(final String mail, final String password);

    /**
<<<<<<< HEAD
     * Permer de rechercher un user selon son mail
     * 
     * @param mail
     * @return le user recherch�, null sinon
     */
    UserDo findUserByMail(final String mail);

    /**
     * Permer de cr�er un utilisateur en bdd
     * 
     * @param userDo
     * @return le user cr�e
     */
    UserDo createUser(final UserDo userDo);

    /**
     * Permet de retrouver tous les users
=======
     * Affiche la liste des users dans l'ordre alphab�tique
>>>>>>> develop
     * 
     * @param orderBy enum {@link OrderBy} asc ou des
     * @return une liste de user
     */
    List<UserDo> findAllUserOrderBy(final OrderBy orderBy);
}
