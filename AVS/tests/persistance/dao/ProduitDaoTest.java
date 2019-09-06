package persistance.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

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
