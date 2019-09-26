package persistance.produitVendu.impl;

import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import persistance.factory.HibernateFactory;
import persistance.produitVendu.IProduitVenduDao;
import persistance.produitVendu.beanDo.ProduitVenduDo;

/**
 * Implémentation de la gestion de la persistence des produits vendus
 * 
 * @author Rodolphe
 *
 */
public class ProduitVenduDao implements IProduitVenduDao {

    @Override
    public ProduitVenduDo findProduitVenduByIdProduitHistorise(final int idProduitHistorise) {
        final SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Query<ProduitVenduDo> query = session.createQuery("From ProduitVenduDo where idProduitHistorise = :idProduitHistorise ORDER BY numeroVersion DESC", ProduitVenduDo.class);
            // on initialise le paramètre
            query.setParameter("idProduitHistorise", idProduitHistorise);
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
