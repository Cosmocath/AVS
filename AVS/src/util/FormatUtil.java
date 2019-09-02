/**
 * 
 */
package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Cette classe permet de faire la conversion des entiers en String <br/>
 * puis de Date en String.
 * 
 * @author Administrateur
 *
 */
public class FormatUtil {

    /**
     * Format de la date
     * 
     */
    public static final String FORMAT_DATE = "dd/MM/yyyy";

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
        final DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE);
        return dateFormat.format(date);
    }

}
