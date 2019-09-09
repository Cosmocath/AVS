package persistance.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import persistance.users.beanDo.ProfilDo;
import persistance.users.beanDo.UserDo;
import persistance.users.dao.IUserDao;
import util.Factory;
import util.FormatUtil;

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
        Assert.assertEquals("ad", userDo.getNom());
        Assert.assertEquals(userDo.getProfilDo().getNom(), "admin");
        Assert.assertNull(iUserDao.findUserForConnexion("x", "mdp"));
        Assert.assertNull(iUserDao.findUserForConnexion("test.user@gmail.com", "m"));
        Assert.assertNull(iUserDao.findUserForConnexion("x", "m"));
    }

    /**
     * Test method for {@link persistance.users.dao.impl.UserDao#findUserByMail(java.lang.String)}.
     */
    @Test
    void testFindUserByMail() {
        final IUserDao iUserDao = Factory.getInstance(IUserDao.class);
        final UserDo userDo = iUserDao.findUserByMail("utili.sateur@outlook.com");
        Assert.assertNotNull(userDo);
        Assert.assertEquals("ad", userDo.getNom());
        Assert.assertEquals(userDo.getProfilDo().getNom(), "admin");
        Assert.assertEquals(userDo.getAdresse(), "19_rue_montebello");
        Assert.assertEquals(userDo.getMail(), "utili.sateur@outlook.com");
        Assert.assertEquals(FormatUtil.convertirDateToString(userDo.getDateNaissance()), "11/05/1987");
        Assert.assertEquals(userDo.getPrenom(), "min");
        Assert.assertEquals(userDo.getId(), (Integer) 7);
        Assert.assertTrue(userDo.isActif());
    }

    /**
     * Test method for {@link persistance.users.dao.impl.UserDao#createUser(persistance.users.beanDo.UserDo)}.
     */
    @Test
    void testCreateUser() {
        final IUserDao iUserDao = Factory.getInstance(IUserDao.class);
        final ProfilDo profilDo = new ProfilDo();
        profilDo.setId(2);
        profilDo.setNom("client");
        
        final UserDo userDo = new UserDo();
        userDo.initialiserUser(2, "testNomCreation", "testPrenomCreation", new Date(), "rue test", "acvc", profilDo, "r@t.fr", true);

        assertNotNull(iUserDao.createUser(userDo));
    }
}
