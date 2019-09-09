package persistance.users.dao;

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
     * Permer de rechercher un user selon son mail
     * 
     * @param mail
     * @return le user recherché, null sinon
     */
    UserDo findUserByMail(final String mail);

    /**
     * Permer de créer un utilisateur en bdd
     * 
     * @param userDo
     * @return le user crée
     */
    UserDo createUser(final UserDo userDo);
}
