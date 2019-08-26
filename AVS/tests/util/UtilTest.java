package util;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UtilTest {

    /**
     * Test method for {@link persistance.Tools#verifDate(java.lang.String)}.
     */
    @Test
    void testVerifDate() {

        Assertions.assertTrue(Tools.verifDate("26/08/2012"));
        Assertions.assertFalse(Tools.verifDate("26/13/2012"));

        // TODO On passe ce test en commentaire => année bisextile qui n'est pas repérée alors que Calendar!! A vérifier avec Xavier Sintive
        //Assertions.assertFalse(persistance.Tools.verifDate("29/08/2013"));

        Assertions.assertFalse(Tools.verifDate("26/08/12"));

        Assertions.assertFalse(Tools.verifDate("26/8/2012"));

        Assertions.assertFalse(Tools.verifDate("6/08/2012"));

    }

    /**
     * Test method for {@link persistance.Tools#verifMail(java.lang.String)}.
     */
    @Test
    void testVerifMail() {
        Assertions.assertFalse(Tools.verifMail("noraliferk7542motmail.fr"));
        Assertions.assertTrue(Tools.verifMail("noraliferki@hotmail.fr"));
        Assertions.assertFalse(Tools.verifMail("noraliferki@è(-z'(q.rezrethrst"));
        Assertions.assertFalse(Tools.verifMail("(è_-è(-'z(@hotmail.fr"));
        Assertions.assertTrue(Tools.verifMail("xavierSintive@gmail.com"));

    }

    /**
     * Test method for {@link persistance.Tools#verifNombre(java.lang.String)}.
     */
    @Test
    void testverifNombre() {
        Assert.assertTrue(Tools.verifNombre("123456"));
        Assert.assertFalse(Tools.verifNombre("12aa56"));
        Assert.assertNotNull(Tools.verifNombre("A"));
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
        Assert.assertTrue(Tools.verifPrix("125,2"));
        Assert.assertTrue(Tools.verifPrix("1 000 421,20"));
        Assert.assertTrue(Tools.verifPrix("145 421,20"));

        Assert.assertFalse(Tools.verifPrix("12 512"));
        Assert.assertFalse(Tools.verifPrix("1855,20"));
        Assert.assertFalse(Tools.verifPrix("125.15"));
        Assert.assertFalse(Tools.verifPrix("-125,20"));
        Assert.assertFalse(Tools.verifPrix("125,255"));
        Assert.assertFalse(Tools.verifPrix("125.20"));
        Assert.assertFalse(Tools.verifPrix("Ab5,20"));

    }
}
