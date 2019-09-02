/**
 * 
 */
package persistance.users.dao.impl;

import persistance.users.beanDo.UserDo;

/**
 * @author Administrateur
 *
 */
public interface IUserDao {

    UserDo findUserForConnexion(final String mail, final String password);

}
