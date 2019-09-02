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

    public static final String FORMAT_DATE = "dd/MM/yyyy";

    /**
     * Permet de convertir un entier en String
     * 
     * @param entier
     * @return
     */
    public static String convertirEntierToString(final int entier) {
        return Integer.toString(entier);

    }

    /**
     * Permet de convertir une date en String
     * 
     * @param date
     * @return
     */
    public static String convertirDateToString(final Date date) {
        final DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE);
        return dateFormat.format(date);
    }

}
