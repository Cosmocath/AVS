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

    //Conversion entier en string
    /**
     * @param entier
     * @return
     */
    public String convertirEntierToString(final int entier) {
        //On retourne directement 
        return Integer.toString(entier);

    }

    //Conversion
    public String convertirDateToString(final Date date) {
        final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }

}
