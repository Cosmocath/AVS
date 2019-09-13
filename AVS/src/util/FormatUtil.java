/**
 * 
 */
package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Cette classe permet de faire la conversion de types différents en String <br/>
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
     * Permet de convertir un entier en String
     * 
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
     * 
     * @param date
     * @return
     */
    public static String convertirDateToString(final Date date) {
        final DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE);
        return dateFormat.format(date);
    }

    /**
     * Permet de convertir une String en Date
     * 
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date convertirStringToDate(final String date) throws ParseException {
        final Date date1 = new SimpleDateFormat(FORMAT_DATE).parse(date);
        return date1;
    }
}
