/**
 * 
 */
package persistance.droit.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import persistance.droit.beanDo.DroitDo;
import persistance.droit.beanDo.ProfilDroitDo;
import persistance.droit.dao.IDroitAccesUrl;
import persistance.factory.HibernateFactory;

/**
 * @author Administrateur
 *
 */
public class DroitAccesUrl implements IDroitAccesUrl {

    private SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    private DroitAccesUrl() {

    }

    /**
     * mappe setprofilDroits ----> liste(liste de profil)
     * 
     * @param setprofilDroits
     * @return liste
     */
    private List<String> mapToListProfilDroit(final Set<ProfilDroitDo> setprofilDroits) {
        final List<String> liste = new ArrayList<>();
        for (ProfilDroitDo profilDroitDo : setprofilDroits) {
            liste.add(profilDroitDo.getProfilDo().getNom());
        }
        return liste;
    }

    /**
     * mappe List<DroitDo> -----> Map<String, List<String>>
     * 
     * @param listeDroits
     * @return map
     */
    private Map<String, List<String>> mapToListDroits(final List<DroitDo> listeDroits) {
        final Map<String, List<String>> map = new HashMap<>();
        for (DroitDo droitDo : listeDroits) {
            if (map.get(droitDo.getUrl()) == null) {
                map.put(droitDo.getUrl(), mapToListProfilDroit(droitDo.getSetProfilDroits()));
            }

        }
        return map;
    }

    @Override
    public Map<String, List<String>> findAllDroits() {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Query<DroitDo> query = session.createQuery("From DroitDo ", DroitDo.class);
            final List<DroitDo> listeDroitDo = query.getResultList();
            final Map<String, List<String>> map = mapToListDroits(listeDroitDo);
            session.flush();
            transaction.commit();
            return map;
        } catch (final HibernateException hibernateException) {
            // on peut catcher des HibernateException
            hibernateException.printStackTrace();
        }

        return null;
    }

}
