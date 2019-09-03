/**
 * 
 */
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
import util.OrderBy;

/**
 * ProduitDao qui implémente l'interface IProduitDao
 * 
 * @author Nora Liferki
 *
 */
public class ProduitDao implements IProduitDao {

    // on peut mettre la sessionFactory en attribut
    private SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    private ProduitDao() {
        // empty constructor
    }

    @Override
    public List<ProduitDo> findAllProduitOrderBy(final OrderBy orderBy) {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            List<ProduitDo> listeProduitDo = new ArrayList<>();
            String req = "From ProduitDo WHERE actif = 1 ORDER BY designation ";

            if (OrderBy.ASC.equals(orderBy)) {
                req += " ASC";
            } else {
                req += "DESC";
            }
            final Query<ProduitDo> query = session.createQuery(req, ProduitDo.class);
            listeProduitDo = query.getResultList();
            session.flush();
            transaction.commit();
            return listeProduitDo;

            // On gère l'exception 
        } catch (final HibernateException hibernateException) {
            hibernateException.printStackTrace();
        }
        return new ArrayList<>();
    }
}
