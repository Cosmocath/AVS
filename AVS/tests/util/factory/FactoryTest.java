package util.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import util.factory.factoryClass.IClassNoImpl;
import util.factory.factoryClass.IClassNoPrivateConstructor;
import util.factory.factoryClass.IClassNotImplemented;
import util.factory.factoryClass.IClassOk;
import util.factory.factoryClass.impl.ClassOk;

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
        // pas d'impl�mentation
        Assertions.assertThrows(IllegalArgumentException.class, () -> Factory.getInstance(IClassNoImpl.class));
        // constructeur non priv�
        Assertions.assertThrows(RuntimeException.class, () -> Factory.getInstance(IClassNoPrivateConstructor.class));
        // interface non impl�ment�e par la classe
        Assertions.assertThrows(RuntimeException.class, () -> Factory.getInstance(IClassNotImplemented.class));
    }

}