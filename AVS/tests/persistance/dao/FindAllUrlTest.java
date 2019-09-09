package persistance.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import persistance.droit.dao.IDroitDao;
import util.Factory;

/**
 * @author Administrateur
 *
 */
class FindAllUrlTest {
   

    /**
     * Test method for {@link persistance.droit.dao.impl.DroitAccesUrl#findAllDroits()}.
     */
    @Test
    void testFindAllDroits() {
        final IDroitDao iDroitAcces = Factory.getInstance(IDroitDao.class);
        assertEquals(3, iDroitAcces.findAllDroits().size());
    }

}
