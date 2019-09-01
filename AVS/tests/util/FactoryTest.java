/**
 * 
 */
package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import util.factoryClass.IClassNoImpl;
import util.factoryClass.IClassNoPrivateConstructor;
import util.factoryClass.IClassNotImplemented;
import util.factoryClass.IClassOk;
import util.factoryClass.impl.ClassOk;

/**
 * @author Xavier
 *
 */
class FactoryTest {

    /**
     * Test method for {@link util.Factory#getInstance(java.lang.Class)}.
     */
    @Test
    void testGetInstance() {
        final IClassOk iClassOk = Factory.getInstance(IClassOk.class);
        Assertions.assertNotNull(iClassOk);
        Assertions.assertEquals(iClassOk, Factory.getInstance(IClassOk.class));

        // pas une classe
        Assertions.assertThrows(IllegalArgumentException.class, () -> Factory.getInstance(ClassOk.class));
        // pas d'implémentation
        Assertions.assertThrows(IllegalArgumentException.class, () -> Factory.getInstance(IClassNoImpl.class));
        // constructeur non privé
        Assertions.assertThrows(RuntimeException.class, () -> Factory.getInstance(IClassNoPrivateConstructor.class));
        // interface non implémentée par la classe
        Assertions.assertThrows(RuntimeException.class, () -> Factory.getInstance(IClassNotImplemented.class));
    }

}
