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
     * @return le user recherch�, null sinon
     */
    UserDo findUserForConnexion(final String mail, final String password);

    /**
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
     * 
     * 
     * @return la liste de tous les users, vide ou remplie
     */
    List<UserDo> findAllUserDo();
}
