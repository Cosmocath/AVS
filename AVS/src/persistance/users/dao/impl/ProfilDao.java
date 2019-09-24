package persistance.users.dao.impl;

import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import persistance.factory.HibernateFactory;
import persistance.users.beanDo.ProfilDo;
import persistance.users.dao.IProfilDao;

/**
 * Implementation de IProfilDao
 * 
 * @author Administrator
 *
 */
public class ProfilDao implements IProfilDao {
    private SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    /**
     * Constructeur
     */
    private ProfilDao() {
        //empty method
    }

    @Override
    public ProfilDo findProfilById(final Integer id) {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();

            final Query<ProfilDo> query = session.createQuery("From ProfilDo where id_Profil = :id_Profil", ProfilDo.class);
            query.setParameter("id_Profil", id);

            final Optional<ProfilDo> profilDo = query.uniqueResultOptional();

            session.flush();
            transaction.commit();

            return profilDo.orElse(null);
        } catch (final HibernateException hibernateException) {
            hibernateException.printStackTrace();
        }
        return null;
    }

}
