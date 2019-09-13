package persistance.produit.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import persistance.factory.HibernateFactory;
import persistance.produit.beanDo.ProduitDo;
import persistance.produit.dao.IProduitDao;
import util.enumeration.OrderBy;

/**
 * ProduitDao qui impl�mente l'interface IProduitDao
 * 
 * @author Nora Liferki
 *
 */
public class ProduitDao implements IProduitDao {

    /**
     * Constructeur
     * 
     */
    private ProduitDao() {
        // empty constructor
    }

    @Override
    public List<ProduitDo> findAllProduitOrderBy(final OrderBy orderBy) {
        final SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            String req = "From ProduitDo WHERE actif = 1 ORDER BY designation";
            if (OrderBy.ASC.equals(orderBy)) {
                req += " ASC";
            } else {
                req += " DESC";
            }
            final Query<ProduitDo> query = session.createQuery(req, ProduitDo.class);
            final List<ProduitDo> listeProduitDo = query.getResultList();
            session.flush();
            transaction.commit();
            return listeProduitDo;

            // On g�re l'exception 
        } catch (final HibernateException hibernateException) {
            hibernateException.printStackTrace();
        }
        return new ArrayList<>();
    }
}
