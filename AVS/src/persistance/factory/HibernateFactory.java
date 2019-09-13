package persistance.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Administrateur
 *
 */
public class HibernateFactory {

    private static SessionFactory sessionFactory = null;

    /**
     * Permet de retourner une sessionFactory en Singleton
     * 
     * @return la sessionFactory
     */
    public static SessionFactory getSessionFactory() {
        synchronized (HibernateFactory.class) {
            // si la sessionFactory n'est pas initialis�e
            if (sessionFactory == null) {
                // on l'initialise : on va chercher l'emplacement par d�faut du hibernate.cgf.xml
                sessionFactory = new Configuration().configure().buildSessionFactory();
                // si on veut utiliser un autre nom/emplacement, il faut le pr�ciser dans le .configure()
            }
            return sessionFactory;
        }
    }

}
