package persistance.produitVendu.dao.impl;

import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import persistance.factory.HibernateFactory;
import persistance.produitVendu.beanDo.ProduitVenduDo;
import persistance.produitVendu.dao.IProduitVenduDao;

/**
 * Implémentation de la gestion de la persistence des produits vendus
 * 
 * @author Rodolphe
 *
 */
public class ProduitVenduDao implements IProduitVenduDao {

    /**
     * Constructeur vide
     */
    private ProduitVenduDao() {
        // Empty method
    }

    @Override
    public ProduitVenduDo findProduitVenduByIdProduitHistoriseAndVersion(final int idProduitHistorise, final int version) {
        final SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Query<ProduitVenduDo> query = session.createQuery("From ProduitVenduDo where idProduitHistorise = :idProduitHistorise and numeroVersion = :version", ProduitVenduDo.class);
            // on initialise les paramètres
            query.setParameter("idProduitHistorise", idProduitHistorise);
            query.setParameter("version", version);
            final Optional<ProduitVenduDo> produitDo = query.uniqueResultOptional();
            session.flush();
            transaction.commit();
            return produitDo.orElse(null);
        } catch (final HibernateException hibernateException) {
            // on peut catcher des HibernateException
            hibernateException.printStackTrace();
        }
        return null;
    }

}
