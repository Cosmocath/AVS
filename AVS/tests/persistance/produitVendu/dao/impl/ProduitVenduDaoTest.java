/**
 * 
 */
package persistance.produitVendu.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import persistance.factory.HibernateFactory;
import persistance.produitVendu.dao.IProduitVenduDao;
import util.factory.Factory;

/**
 * @author Rodolphe
 *
 */
class ProduitVenduDaoTest {
    /**
     * 
     */
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
     * Test method for {@link persistance.produitVendu.dao.impl.ProduitVenduDao#findProduitVenduByIdProduitHistoriseAndVersion(int, int)}.
     */
    @Test
    void testFindProduitVenduByIdProduitHistoriseAndVersion() {
        final IProduitVenduDao iProduitVenduDao = Factory.getInstance(IProduitVenduDao.class);
        assertNull(iProduitVenduDao.findProduitVenduByIdProduitHistoriseAndVersion(18, 1));
        assertNotNull(iProduitVenduDao.findProduitVenduByIdProduitHistoriseAndVersion(14, 2));
        assertEquals("demenagement 3", iProduitVenduDao.findProduitVenduByIdProduitHistoriseAndVersion(14, 3).getDesignation());
    }

}
