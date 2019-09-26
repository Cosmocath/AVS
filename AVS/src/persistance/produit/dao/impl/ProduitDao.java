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
import util.enumeration.OrderBy;

/**
 * ProduitDao qui impl�mente l'interface IProduitDao
 * 
 * @author Nora Liferki
 *
 */
public class ProduitDao implements IProduitDao {

    private SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    /**
     * Constructeur
     * 
     */
    private ProduitDao() {
        // empty constructor
    }

    @Override
    public List<ProduitDo> findAllProduitOrderBy(final OrderBy orderBy) {
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

    @Override
    public List<ProduitDo> findAllProduitAdminOrderBy(final OrderBy orderBy) {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            String req = "From ProduitDo ORDER BY designation";
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

    @Override
    public ProduitDo createProduit(final ProduitDo produitDo) {
        final SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.save(produitDo);
            session.flush();
            transaction.commit();
            return produitDo;
        } catch (final HibernateException hibernateException) {
            hibernateException.printStackTrace();
        }
        return null;
    }

    @Override
    public ProduitDo findByReference(final String reference) {
        final SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Query<ProduitDo> query = session.createQuery("From ProduitDo where reference = :reference", ProduitDo.class);
            // on initialise le param�tre
            query.setParameter("reference", reference);
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

    @Override
    public ProduitDo findProduitById(final Integer idProduit) {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Query<ProduitDo> query = session.createQuery("From ProduitDo WHERE id = :idProduit", ProduitDo.class);
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

    @Override
    public ProduitDo updateProduit(final Integer idProduit, final ProduitDo produitDo) {
        try (final Session session = sessionFactory.openSession()) {

            final Transaction transaction = session.beginTransaction();
            final StringBuilder hqlQuery = new StringBuilder();
            hqlQuery.append("update ProduitDo set designation = :designation,reference = :reference, description = :description, prix = :prix where id = :idProduit");

            final Query<?> query = session.createQuery(hqlQuery.toString());
            // intialisation des param�tres
            query.setParameter("designation", produitDo.getDesignation());
            query.setParameter("reference", produitDo.getReference());
            query.setParameter("description", produitDo.getDescription());
            query.setParameter("prix", produitDo.getPrix());
            query.setParameter("idProduit", idProduit);
            query.executeUpdate();

            // on "compl�te" le Do � retourner
            produitDo.setId(idProduit);

            session.flush();
            transaction.commit();
            return produitDo;
        } catch (final HibernateException hibernateException) {
            // on peut catcher des HibernateException
            hibernateException.printStackTrace();
        }
        return null;
    }

}
