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
     * Permet de rechercher un user selon son mail et son mot de passe
     * 
     * @param mail
     * @param password
     * @return le user recherch�, null sinon
     */
    UserDo findUserForConnexion(final String mail, final String password);

    /**
     * Permet de rechercher un user selon son mail
     * 
     * @param mail
     * @return le user recherch�, null sinon
     */
    UserDo findUserByMail(final String mail);

    /**
     * Permet de cr�er un utilisateur en bdd
     * 
     * @param userDo
     * @return le user cr�e
     */
    UserDo createUser(final UserDo userDo);

    /**
     * Affiche la liste des users dans l'ordre alphab�tique
     * 
     * @param orderBy enum {@link OrderBy} asc ou des
     * @return une liste de user
     */
    List<UserDo> findAllUserOrderBy(final OrderBy orderBy);

    /**
     * permet d'afficher les d�tails d'un utilisateur
     * 
     * @param id
     * @return un user s'il existe sinon null
     */
    UserDo findUserDo(final Integer id);

    /**
     * Permet de mettre � jour un user
     * 
     * @param id du user � mettre � jour
     * @param userDo le user
     * @return le user mis � jour, null en cas de probl�me
     */
    UserDo updateUserDo(final Integer id, final UserDo userDo);

}
