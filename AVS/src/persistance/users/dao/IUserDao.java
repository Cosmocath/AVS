package persistance.users.dao;

import java.util.List;

import persistance.users.beanDo.UserDo;

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
     * @return le user recherché, null sinon
     */
    UserDo findUserForConnexion(final String mail, final String password);

    /**
     * Permet de retrouver tous les users
     * 
     * 
     * @return la liste de tous les users, vide ou remplie
     */
    List<UserDo> findAllUserDo();
}
