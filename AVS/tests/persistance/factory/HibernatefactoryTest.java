package persistance.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

/**
 * @author Administrateur
 *
 */
class HibernateFactoryTest {
    public static SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    /**
     * Test method for {@link persistance.factory.HibernateFactory#getSessionFactory()}.
     */
    @Test
    final void testGetSessionFactory() {
        assertNotNull(sessionFactory);
        assertEquals(sessionFactory, HibernateFactory.getSessionFactory());
        try (final Session session = sessionFactory.openSession()) {
            assertNotNull(session);
            assertNotNull(session.createNativeQuery("select 1 from dual").getSingleResult());
        }
    }

}
