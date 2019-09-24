package util.tools;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Administrateur
 *
 */
class FormatUtilTest {

    /**
     * Test method for {@link util.tools.FormatUtil#convertirEntierToString(int)}.
     */
    @Test
    void testConvertionEntierToString() {
        Assert.assertEquals("123", FormatUtil.convertirEntierToString(123));
        Assert.assertNotEquals(123, FormatUtil.convertirEntierToString(123));
        Assert.assertNotEquals("023", FormatUtil.convertirEntierToString(123));
    }

    /**
     * Le mois dans le calendar est compt� � partir de zero c'est-�-dire que le mois de janvier est le mois 0 et le mois de d�cembre est le mois 11. <br/>
     * Important pour la saisie du test. <br/>
     * 
     * Test method for {@link util.tools.FormatUtil#convertirDateToString(java.util.Date)}.
     */
    @Test
    void testConvertionDateToString() {
        final Calendar calendar1 = Calendar.getInstance();
        final Calendar calendar2 = Calendar.getInstance();
        calendar1.set(2015, Calendar.DECEMBER, 04);
        calendar2.set(1981, Calendar.MARCH, 14);
        Assert.assertEquals("04/12/2015", FormatUtil.convertirDateToString(calendar1.getTime()));
        Assert.assertEquals("14/03/1981", FormatUtil.convertirDateToString(calendar2.getTime()));
        Assert.assertNotEquals("04/12/15", FormatUtil.convertirDateToString(calendar2.getTime()));
        Assert.assertNotEquals("14/81", FormatUtil.convertirDateToString(calendar2.getTime()));
        Assert.assertNotEquals("2/2015", FormatUtil.convertirDateToString(calendar2.getTime()));
        Assert.assertNotEquals("2015", FormatUtil.convertirDateToString(calendar2.getTime()));
        Assert.assertNotEquals("04-12-2015", FormatUtil.convertirDateToString(calendar2.getTime()));
        Assert.assertNotEquals("14-03-1981", FormatUtil.convertirDateToString(calendar2.getTime()));
        Assert.assertNotEquals("12-2015", FormatUtil.convertirDateToString(calendar2.getTime()));
        Assert.assertNotEquals("12-15", FormatUtil.convertirDateToString(calendar2.getTime()));
        Assert.assertNotEquals("03-81", FormatUtil.convertirDateToString(calendar2.getTime()));
        Assert.assertNotEquals(Calendar.AUGUST, FormatUtil.convertirDateToString(calendar2.getTime()));
        Assert.assertNotEquals(Calendar.AUGUST, FormatUtil.convertirDateToString(calendar1.getTime()));

    }

    /**
     * Test method for {@link util.tools.FormatUtil#convertirStringToDouble(java.lang.String)}.
     */
    @Test
    final void testConvertirStringToDouble() {
        Assert.assertEquals(Double.valueOf(123), FormatUtil.convertirStringToDouble("123"));
        Assert.assertNotEquals(123, FormatUtil.convertirStringToDouble("123"));

    }

    /**
     * Test method for {@link util.tools.FormatUtil#convertirDoubleToString(java.lang.Double)}.
     */
    @Test
    final void testConvertirDoubleToString() {
        Assertions.assertEquals("123,00", FormatUtil.convertirDoubleToString(Double.valueOf(123.00)));
        Assertions.assertEquals("123,00", FormatUtil.convertirDoubleToString(Double.valueOf(123.0)));
        Assertions.assertEquals("3,00", FormatUtil.convertirDoubleToString(Double.valueOf(3)));
        // TODO XSI : � revoir
        //Assertions.assertEquals("1 123,05", FormatUtil.convertirDoubleToString(Double.valueOf(1123.05)));
        Assertions.assertEquals("123,00", FormatUtil.convertirDoubleToString(Double.valueOf(123.002)));
    }
}
