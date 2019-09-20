package persistance.droit.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import persistance.droit.dao.IDroitDao;
import persistance.factory.HibernateFactory;
import util.factory.Factory;

/**
 * @author Administrateur
 *
 */
class FindAllUrlTest {

    @BeforeEach
    public void initData() {
        try (final Session session = HibernateFactory.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            // on lit le fichier
            try (final Scanner scanner = new Scanner(new FileReader("tests/dataSet/avs_DML.sql"))) {
                while (scanner.hasNext()) {
                    final String sql = scanner.nextLine();
                    // pour chaque ligne non vide
                    if (!sql.isEmpty()) {
                        // on l'exécute en tant que query native (sql natif)
                        final NativeQuery<?> query = session.createNativeQuery(sql);
                        query.executeUpdate();
                    }
                }
            } catch (final FileNotFoundException e) {
                e.printStackTrace();
            }
            transaction.commit();
        }
    }

    /**
     * Test method for {@link persistance.droit.dao.impl.DroitAccesUrl#findAllDroits()}.
     */
    @Test
    void testFindAllDroits() {
        final IDroitDao iDroitAcces = Factory.getInstance(IDroitDao.class);
        assertEquals(10, iDroitAcces.findAllDroits().size());
        assertEquals("changerLangue.do", iDroitAcces.findAllDroits().get(0).getUrl());
        assertEquals(3, iDroitAcces.findAllDroits().get(0).getSetProfilDroits().size());
    }

}
