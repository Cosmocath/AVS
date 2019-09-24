package persistance.users.dao.impl;

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

import persistance.commande.dao.ICommandeDao;
import persistance.factory.HibernateFactory;
import persistance.users.beanDo.UserDo;
import persistance.users.dao.IUserDao;
import util.enumeration.OrderBy;
import util.factory.Factory;

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

    /**
     * Test method for {@link persistance.user.dao.impl.UserDao#findAllUserDo()}.
     */
    @Test
    void testFindUserDo() {
        final IUserDao iUserDao = Factory.getInstance(IUserDao.class);
        final ICommandeDao iCommandeDao = Factory.getInstance(ICommandeDao.class);
        Assertions.assertNotNull(iUserDao.findUserDo(9));
        Assertions.assertNull(iUserDao.findUserDo(2));
        Assertions.assertEquals("Dupont", iUserDao.findUserDo(9).getNom());
        Assertions.assertEquals("19_rue_montebello", iUserDao.findUserDo(7).getAdresse());
        Assertions.assertEquals(2, iCommandeDao.findAllCommandeDo(9).size());
    }

}
