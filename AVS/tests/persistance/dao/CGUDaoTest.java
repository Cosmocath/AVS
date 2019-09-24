package persistance.dao;

import org.junit.jupiter.api.Assertions;
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
    void lireCGUDaoTest() {
        final ICGUDao iCGUDao = Factory.getInstance(ICGUDao.class);
        iCGUDao.lireCGUDao();
        Assertions.assertNotNull(iCGUDao.lireCGUDao());
    }

}