/**
 * 
 */
package persistance.commande.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import persistance.commande.beanDo.CommandeDo;
import persistance.commande.dao.ICommandeDao;
import persistance.factory.HibernateFactory;

/**
 * Implémentation de ICommandeDao
 * 
 * @author Administrateur
 * 
 */
public class CommandeDao implements ICommandeDao {

    private SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    /**
     * 
     */
    private CommandeDao() {
        //empty method
    }

    /**
     *
     */
    @Override
    public List<CommandeDo> findAllCommandeDo(final int id_Utilisateur) {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Query<CommandeDo> query = session.createQuery("From CommandeDo where id_Utilisateur = :id_Utilisateur order by date_Commande desc", CommandeDo.class);
            query.setParameter("id_Utilisateur", id_Utilisateur);
            final List<CommandeDo> listeCommandeDo = query.getResultList();

            session.flush();
            transaction.commit();
            return listeCommandeDo;
        } catch (final HibernateException hibernateException) {
            hibernateException.printStackTrace();
        }
        return new ArrayList<>();

    }
}
