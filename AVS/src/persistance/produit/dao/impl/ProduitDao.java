package persistance.produit.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import persistance.factory.HibernateFactory;
import persistance.produit.beanDo.ProduitDo;
import persistance.produit.dao.IProduitDao;
import util.OrderBy;

/**
 * ProduitDao qui implémente l'interface IProduitDao
 * 
 * @author Nora Liferki
 *
 */
public class ProduitDao implements IProduitDao {

    private SessionFactory     sessionFactory = HibernateFactory.getSessionFactory();

    private static IProduitDao iProduitDao    = null;

    /**
     * Constructeur
     * 
     */
    private ProduitDao() {
        // empty constructor
    }

    /**
     * Méthode getInstance pour le singleton
     * 
     * @return un iProduitDao
     */
    public static IProduitDao getInstance() {
        synchronized (ProduitDao.class) {
            if (iProduitDao == null) {
                iProduitDao = new ProduitDao();
            }
            return iProduitDao;
        }
    }

    @Override
    public List<ProduitDo> findAllProduitOrderBy(final OrderBy orderBy) {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            String req = "From ProduitDo WHERE actif = 1 ORDER BY designation ";
            if (OrderBy.ASC.equals(orderBy)) {
                req += " ASC";
            } else {
                req += "DESC";
            }
            final Query<ProduitDo> query = session.createQuery(req, ProduitDo.class);
            List<ProduitDo> listeProduitDo = query.getResultList();
            session.flush();
            transaction.commit();
            return listeProduitDo;

            // On gère l'exception 
        } catch (final HibernateException hibernateException) {
            hibernateException.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public ProduitDo findProduitById(final Integer idProduit) {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Query<ProduitDo> query = session.createQuery("From ProduitDo WHERE actif = 1 and id = :idProduit", ProduitDo.class);
            query.setParameter("idProduit", idProduit);
            // regarder la Javadoc de Optional
            final Optional<ProduitDo> produitDo = query.uniqueResultOptional();

            session.flush();
            transaction.commit();
            // suite de la feature Optional de Java 8
            return produitDo.orElse(null);
        } catch (final HibernateException hibernateException) {
            // on peut catcher des HibernateException
            hibernateException.printStackTrace();
        }
        return null;
    }
}
