package persistance.users.dao.impl;

import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import persistance.factory.HibernateFactory;
import persistance.users.beanDo.UserDo;
import persistance.users.dao.IUserDao;

/**
 * Implementation de IUserDao
 * 
 * @author Administrateur
 *
 */
public class UserDao implements IUserDao {

    private SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    /**
     * 
     */
    private UserDao() {
        //empty method
    }

    @Override
    public UserDo findUserForConnexion(final String mail, final String password) {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Query<UserDo> query = session.createQuery("From UserDo where mail = :mail and password = :password", UserDo.class);
            // on initialise le paramètre
            query.setParameter("mail", mail);
            query.setParameter("password", password);
            // regarder la Javadoc de Optional
            final Optional<UserDo> userDo = query.uniqueResultOptional();

            session.flush();
            transaction.commit();
            // suite de la feature Optional de Java 8
            return userDo.orElse(null);
        } catch (final HibernateException hibernateException) {
            // on peut catcher des HibernateException
            hibernateException.printStackTrace();
        }
        return null;
    }
}
