package persistance.dao;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import persistance.factory.HibernateFactory;
import persistance.produit.beanDo.ProduitDo;
import persistance.produit.dao.IProduitDao;
import util.Factory;
import util.OrderBy;

/**
 * Permet de tester la classe ProduitDao
 * 
 * @author Nora Liferki
 *
 */
class ProduitDaoTest {

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
                        // on l'ex�cute en tant que query native (sql natif)
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
     * Test method for {@link persistance.produit.dao.impl.ProduitDao#findAllProduitOrderBy(util.OrderBy)}.
     */
    @Test
    void testFindAllProduitOrderBy() {
        final IProduitDao iProduitDao = Factory.getInstance(IProduitDao.class);
        final List<ProduitDo> listeProduitDo = iProduitDao.findAllProduitOrderBy(OrderBy.ASC);
        assertEquals(2, listeProduitDo.size());
        assertEquals("demenagement", listeProduitDo.get(0).getDesignation());
        assertEquals("jadinage", listeProduitDo.get(1).getDesignation());
    }
}
