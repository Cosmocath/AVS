/**
 * 
 */
package persistance.dao;

import org.junit.jupiter.api.Test;

import persistance.cgu.dao.ICGUDao;
import util.factory.Factory;


/**
 * @author Administrateur
 *
 */
class CGUDaoTest {

    /**
     * Test method for {@link persistance.cgu.dao.impl.CGUDao#lireCGUDao()}.
     */
    @Test
    void LireCGUDaoTest() {
        final ICGUDao iCGUDao = Factory.getInstance(ICGUDao.class);
        iCGUDao.lireCGUDao();
        // TODO XSI : compléter le test
    }

}
