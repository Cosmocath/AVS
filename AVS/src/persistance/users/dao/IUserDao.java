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
     * @return le user recherché, null sinon
     */
    UserDo findUserForConnexion(final String mail, final String password);

    /**
     * Affiche la liste des users dans l'ordre alphabétique
     * 
     * @param orderBy enum {@link OrderBy} asc ou des
     * @return une liste de user
     */
    List<UserDo> findAllUserOrderBy(final OrderBy orderBy);
}
