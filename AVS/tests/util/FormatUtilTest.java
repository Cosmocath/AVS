package util;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FormatUtilTest {

    /**
     * 
     */
    @Test
    void testConvertionEntierToString() {
        Assert.assertEquals("123", FormatUtil.convertirEntierToString(123));
        Assert.assertNotEquals(123, FormatUtil.convertirEntierToString(123));
        Assert.assertNotEquals("023", FormatUtil.convertirEntierToString(123));

    }

    /**
     * 
     */
    @Test
    void testConvertionDateToString() {
        final Calendar calendar1 = Calendar.getInstance();
        final Calendar calendar2 = Calendar.getInstance();
//        le mois dans le calendar est compté à partir de zero c'est-à-dire que le mois de janvier
//        est le mois 0 et le mois de décembre est le mois 11.
//        Important pour la saisie du test.
        calendar1.set(2015, 1, 04);
        calendar2.set(1958, 8, 28);
        Assert.assertEquals("04/02/2015", FormatUtil.convertirDateToString(calendar1.getTime()));
        Assert.assertNotEquals("30/12/2015", FormatUtil.convertirDateToString(calendar2.getTime()));

    }
}
