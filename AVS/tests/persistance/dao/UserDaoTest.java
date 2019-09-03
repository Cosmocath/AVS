/**
 * 
 */
package persistance.dao;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import persistance.users.beanDo.UserDo;
import persistance.users.dao.IUserDao;
import util.Factory;

/**
 * @author Administrateur
 *
 */
class UserDaoTest {

    /**
     * Test method for {@link persistance.users.dao.impl.UserDao#findUserForConnexion(java.lang.String, java.lang.String)}.
     */
    @Test
    void testFindUserForConnexion() {
        final IUserDao iUserDao = Factory.getInstance(IUserDao.class);
        final UserDo userDo = iUserDao.findUserForConnexion("utili.sateur@outlook.com", "pass");
        Assert.assertNotNull(userDo);
        Assert.assertEquals(userDo.getNom(), "ad");
        Assert.assertEquals(userDo.getProfilDo().getNom(), "admin");
        Assert.assertNull(iUserDao.findUserForConnexion("x", "mdp"));
        Assert.assertNull(iUserDao.findUserForConnexion("test.user@gmail.com", "m"));
        Assert.assertNull(iUserDao.findUserForConnexion("x", "m"));
    }
}
