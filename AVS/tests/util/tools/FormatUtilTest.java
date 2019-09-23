package util.tools;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;

import org.junit.Assert;
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
     * Le mois dans le calendar est compt� � partir de zero c'est-�-dire que le mois de janvier est le mois 0 et le mois de d�cembre est le mois 11. <br/>
     * Important pour la saisie du test. <br/>
     * 
     * Test method for {@link util.tools.FormatUtil#convertirStringToDate(java.util.String)}.
     */
    @Test
    void testConvertionStringToDate() {
        final String date1 = "23/08/2017";
        final String date2 = "23-08-2017";

        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(FormatUtil.convertirStringToDate(date1));

        assertEquals(Calendar.AUGUST, calendar.get(Calendar.MONTH));
        assertEquals(23, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(2017, calendar.get(Calendar.YEAR));

        assertNull(FormatUtil.convertirStringToDate(date2));
    }
}
