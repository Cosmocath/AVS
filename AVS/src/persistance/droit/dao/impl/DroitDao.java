package persistance.droit.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import persistance.droit.beanDo.DroitDo;
import persistance.droit.dao.IDroitDao;
import persistance.factory.HibernateFactory;

/**
 * Implémentation de IDroitaDao
 * 
 * @author Guy-Jöel et Mireille
 *
 */
public class DroitDao implements IDroitDao {

    private SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    /**
     * Constructeur privé
     */
    private DroitDao() {
        //Empty method
    }

    @Override
    public List<DroitDo> findAllDroits() {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Query<DroitDo> query = session.createQuery("From DroitDo as dd order by dd.url asc", DroitDo.class);
            final List<DroitDo> listeDroitDo = query.getResultList();
            session.flush();
            transaction.commit();
            return listeDroitDo;
        } catch (final HibernateException hibernateException) {
            // on peut catcher des HibernateException
            hibernateException.printStackTrace();
        }

        return null;
    }

}
