/**
 * 
 */
package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrateur
 *
 */
public class FormatUtil {

    /**
     * Conversion d'entier en string
     * 
     * @param entier
     * @return
     */
    public static String convertirEntierToString(final int entier) {
        return Integer.toString(entier);

    }

    /**
     * Conversion de date en String
     * 
     * @param date
     * @return
     */
    public static String convertirDateToString(final Date date) {
        final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

}
