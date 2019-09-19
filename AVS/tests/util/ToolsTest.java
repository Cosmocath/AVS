package util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import util.tools.Tools;

/**
 * Classe JUnit permettant de tester les méthodes de la classe Tools
 * 
 * @author Nora Liferki
 *
 */
public class ToolsTest {

    /**
     * Test method for {@link persistance.Tools#verifDate(java.lang.String)}.
     */
    @Test
    void testVerifDate() {

        Assertions.assertTrue(Tools.verifDate("26/08/2012"));
        Assertions.assertTrue(Tools.verifDate("29/02/2016"));

        Assertions.assertFalse(Tools.verifDate("26/13/2012"));
        Assertions.assertFalse(Tools.verifDate("29/02/2013"));
        Assertions.assertFalse(Tools.verifDate("26/08/12"));
        Assertions.assertFalse(Tools.verifDate("26/8/2012"));
        Assertions.assertFalse(Tools.verifDate("6/08/2012"));
        Assertions.assertFalse(Tools.verifDate("30/02/2012"));

    }

    /**
     * Test method for {@link persistance.Tools#verifMail(java.lang.String)}.
     */
    @Test
    void testVerifMail() {
        Assertions.assertTrue(Tools.verifMail("xavierSintive@gmail.com"));
        Assertions.assertTrue(Tools.verifMail("noraliferki@hotmail.fr"));

        Assertions.assertFalse(Tools.verifMail("noraliferk7542motmail.fr"));
        Assertions.assertFalse(Tools.verifMail("noraliferki@è(-z'(q.rezrethrst"));
        Assertions.assertFalse(Tools.verifMail("(è_-è(-'z(@hotmail.fr"));

    }

    /**
     * Test method for {@link persistance.Tools#verifNombre(java.lang.String)}.
     */
    @Test
    void testverifNombre() {
        Assert.assertTrue(Tools.verifNombre("123456"));

        Assert.assertFalse(Tools.verifNombre("12aa56"));
        Assert.assertFalse(Tools.verifNombre("123456,45"));

    }

    /**
     * Test method for {@link persistance.Tools#verifPrix(java.lang.String)}.
     */
    @Test
    void testVerifPrix() {
        Assert.assertTrue(Tools.verifPrix("125,20"));
        Assert.assertTrue(Tools.verifPrix("1 255,20"));
        Assert.assertTrue(Tools.verifPrix("4 445 555 255,20"));
        Assert.assertTrue(Tools.verifPrix("421 254 111 255,00"));
        Assert.assertTrue(Tools.verifPrix("1,20"));
        Assert.assertTrue(Tools.verifPrix("10,20"));
        Assert.assertTrue(Tools.verifPrix("1 000 421,20"));
        Assert.assertTrue(Tools.verifPrix("145 421,20"));

        Assert.assertFalse(Tools.verifPrix("145,2"));
        Assert.assertFalse(Tools.verifPrix("012,25"));
        Assert.assertFalse(Tools.verifPrix("12 512"));
        Assert.assertFalse(Tools.verifPrix("1855,20"));
        Assert.assertFalse(Tools.verifPrix("125.15"));
        Assert.assertFalse(Tools.verifPrix("-125,20"));
        Assert.assertFalse(Tools.verifPrix("125,255"));
        Assert.assertFalse(Tools.verifPrix("125.20"));
        Assert.assertFalse(Tools.verifPrix("Ab5,20"));

    }

    /**
     * Test method for {@link persistance.Tools#isEmpty(java.lang.String)}.
     */
    @Test
    void testIsEmpty() {
        assertTrue(Tools.isEmpty(""));
        assertTrue(Tools.isEmpty(null));
        assertFalse(Tools.isEmpty("doudou"));
    }
}
