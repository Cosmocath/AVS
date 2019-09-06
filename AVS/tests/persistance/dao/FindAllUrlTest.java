/**
 * 
 */
package persistance.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import persistance.droit.dao.IDroitAccesUrl;
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
        final IDroitAccesUrl iDroitAcces = Factory.getInstance(IDroitAccesUrl.class);
        assertEquals(3, iDroitAcces.findAllDroits().size());
    }

}
