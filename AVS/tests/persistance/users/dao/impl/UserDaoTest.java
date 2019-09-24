package persistance.users.dao.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import persistance.users.beanDo.ProfilDo;
import persistance.factory.HibernateFactory;
import persistance.users.beanDo.UserDo;
import persistance.users.dao.IUserDao;
import util.enumeration.OrderBy;
import util.factory.Factory;
import util.tools.FormatUtil;

/**
 * @author Administrateur
 *
 */
class UserDaoTest {

    /**
     * 
     */
    @BeforeEach
    public void initData() {
        try (final Session session = HibernateFactory.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            // on lit le fichier
            try (final Scanner scanner = new Scanner(new FileReader("tests/dataSet/avs_DML.sql"))) {
                while (scanner.hasNext()) {
                    final String sql = scanner.nextLine();
                    // pour chaque ligne non vide
                    if (!sql.isEmpty()) {
                        // on l'exécute en tant que query native (sql natif)
                        final NativeQuery<?> query = session.createNativeQuery(sql);
                        query.executeUpdate();
                    }
                }
            } catch (final FileNotFoundException e) {
                e.printStackTrace();
            }
            transaction.commit();
        }
    }

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
        assertNotNull(userDo);
        assertEquals("ad", userDo.getNom());
        assertEquals("admin", userDo.getProfilDo().getNom());
        assertEquals("19_rue_montebello", userDo.getAdresse());
        assertEquals("utili.sateur@outlook.com", userDo.getMail());
        assertEquals("11/05/1987", FormatUtil.convertirDateToString(userDo.getDateNaissance()));
        assertEquals("min", userDo.getPrenom());
        assertEquals(Integer.valueOf(7), userDo.getId());
        assertTrue(userDo.isActif());

        // Non null pour un user désactivé car la méthode n'a pas pour but d'enlever les users désactivés
        assertNotNull(iUserDao.findUserByMail("test.user@gmail.com"));
        assertNull(iUserDao.findUserByMail("toto@toto.com"));
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

        final UserDo userDo = UserDo.buildUserDo(2, "testNomCreation", "testPrenomCreation", new Date(), "rue test", "acvc", profilDo, "r@t.fr", true);

        final UserDo userDoRetour = iUserDao.createUser(userDo);
        assertEquals("rue test", userDoRetour.getAdresse());
        assertTrue(userDoRetour.isActif());
    }

    /**
     * Test method for {@link persistance.user.dao.impl.UserDao#findAllUserOrderBy(util.OrderBy)}.
     */
    @Test
    void testFindAllUserOrderBy() {
        final IUserDao iUserDao = Factory.getInstance(IUserDao.class);
        final List<UserDo> listeUserDo = iUserDao.findAllUserOrderBy(OrderBy.ASC);
        Assertions.assertNotNull(listeUserDo);
        assertEquals(4, listeUserDo.size());
        assertEquals("bel.sab@outlook.com", listeUserDo.get(0).getMail());
    }

}
