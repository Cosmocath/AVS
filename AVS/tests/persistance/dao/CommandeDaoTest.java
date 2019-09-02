/**
 * 
 */
package persistance.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import persistance.commande.beanDo.CommandeDo;
import persistance.commande.dao.ICommandeDao;
import util.Factory;

/**
 * @author Administrateur
 *
 */
class CommandeDaoTest {

    /**
     * Test method for {@link persistance.commande.dao.impl.CommandeDao#findAllCommandeDo(int)}.
     */
    @Test
    void testFindAllCommandeDo() {
        final ICommandeDao iCommandeDao = Factory.getInstance(ICommandeDao.class);
        final List<CommandeDo> listeCommandeDo = iCommandeDao.findAllCommandeDo(1);
        Assert.assertNull(listeCommandeDo);
    }

}
