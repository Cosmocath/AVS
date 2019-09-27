package persistance.users.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import persistance.factory.HibernateFactory;
import persistance.users.beanDo.UserDo;
import persistance.users.dao.IUserDao;
import util.enumeration.OrderBy;

/**
 * Implementation de IUserDao
 * 
 * @author Administrator
 *
 */
public class UserDao implements IUserDao {

    private SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    /**
     * Constructeur
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

    @Override
    public UserDo findUserByMail(final String mail) {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Query<UserDo> query = session.createQuery("From UserDo where mail = :mail", UserDo.class);
            // on initialise le paramètre
            query.setParameter("mail", mail);
            // regarder la Javadoc de Optional
            final Optional<UserDo> userDo = query.uniqueResultOptional();

            session.flush();
            transaction.commit();
            // suite de la feature Optional de Java 8
            return userDo.orElse(null);
        }
    }

    @Override
    public List<UserDo> findAllUserOrderBy(final OrderBy orderBy) {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            String req = "From UserDo WHERE actif = 1 ORDER BY mail";
            if (OrderBy.ASC.equals(orderBy)) {
                req += " ASC";
            } else {
                req += " DESC";
            }
            final Query<UserDo> query = session.createQuery(req, UserDo.class);
            final List<UserDo> listeUserDo = query.getResultList();
            session.flush();
            transaction.commit();
            return listeUserDo;

            // On gère l'exception 
        } catch (final HibernateException hibernateException) {
            hibernateException.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public UserDo findUserDo(final Integer id) {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Query<UserDo> query = session.createQuery("From UserDo where id = :id", UserDo.class);
            // on initialise le paramètre
            query.setParameter("id", id);
            // regarder la Javadoc de Optional
            final Optional<UserDo> userDo = query.uniqueResultOptional();
            session.flush();
            transaction.commit();
            // suite de la feature Optional de Java 8
            return userDo.orElse(null);
        } catch (final HibernateException hibernateException) {
            hibernateException.printStackTrace();
        }
        return null;
    }

    @Override
    public UserDo createUser(final UserDo userDo) {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();

            session.save(userDo);
            session.flush();

            transaction.commit();

            return userDo;
        } catch (final HibernateException hibernateException) {
            hibernateException.printStackTrace();
        }
        return null;
    }

    @Override
    public UserDo updateUserDo(final Integer id, final UserDo userDo) {
        try (final Session session = sessionFactory.openSession()) {
            // sans auto-commit , on doit créer une transaction
            final Transaction transaction = session.beginTransaction();
            final StringBuilder hqlQuery = new StringBuilder();
            hqlQuery.append("update UserDo set nom = :nom, prenom = :prenom, dateNaissance = :dateNaissance, password = :password, adresse = :adresse, mail = :mail, profilDo = :profilDo where id = :id");

            final Query<?> query = session.createQuery(hqlQuery.toString());
            // intialisation des paramètres
            query.setParameter("nom", userDo.getNom());
            query.setParameter("prenom", userDo.getPrenom());
            query.setParameter("dateNaissance", userDo.getDateNaissance());
            query.setParameter("password", userDo.getPassword());
            query.setParameter("adresse", userDo.getAdresse());
            query.setParameter("profilDo", userDo.getProfilDo());
            query.setParameter("id", id);
            query.setParameter("mail", userDo.getMail());
            query.executeUpdate();

            session.flush();

            transaction.commit();
            // on "complète" le Do à retourner
            userDo.setId(id);
            return userDo;
        } catch (final HibernateException hibernateException) {
            // on peut catcher des HibernateException
            hibernateException.printStackTrace();
        }
        return null;
    }
}
