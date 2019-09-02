/**
 * 
 */
package persistance.produit.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import persistance.factory.HibernateFactory;
import persistance.produit.beanDo.ProduitDo;
import persistance.produit.dao.IProduitDao;

/**
 * @author Administrateur
 *
 */
public class ProduitDao implements IProduitDao {

    // on peut mettre la sessionFactory en attribut
    private SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    @Override
    //TODO trouver urgemment le fonctionnement du parametre de la méthode => enum avec le orderBy de la base de donnée!!

    public List<ProduitDo> findAllProduitOrderBy() {
        //        try (final Session session = sessionFactory.openSession()) {
        //            final Transaction transaction = session.beginTransaction();
        //            final Query<ProduitDo> query = session.createQuery("From ProduitDo ", ProduitDo.class);
        //            final List<ProduitDo> listeProduitDo = query.getResultList();
        //
        //            session.flush();
        //            transaction.commit();
        //            return listeProduitDo;
        //        } catch (final HibernateException hibernateException) {
        //            // on peut catcher des HibernateException
        //            hibernateException.printStackTrace();
        //        }
        return new ArrayList<>();
    }

}
