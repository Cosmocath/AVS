package persistance.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

/**
 * @author Administrateur
 *
 */
class HibernateFactoryTest {

    public static SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    /**
     * On exécute après tous les tests de cette classe
     */
    @AfterAll
    public static void initData() {
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
     * Test method for {@link persistance.factory.HibernateFactory#getSessionFactory()}.
     */
    @Test
    public final void testGetSessionFactory() {
        assertNotNull(sessionFactory);
        assertEquals(sessionFactory, HibernateFactory.getSessionFactory());
        try (final Session session = sessionFactory.openSession()) {
            assertNotNull(session);
            assertNotNull(session.createNativeQuery("select 1 from dual").getSingleResult());
        }
    }

}
