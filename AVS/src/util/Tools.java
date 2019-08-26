/**
 * 
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrateur Classe Toold permettant de v�rifier les adresses mails, dates, prix, nombres et leurs formats pr�cis
 *
 */
public class Tools {
    /**
     * M�thode verifMail permettant de v�rifier le format de l'adresse mail
     * 
     * @param mail
     * @return true si l'adresse mail est au bon format sinon false
     */
    public static Boolean verifMail(final String mail) {
        final Pattern pattern = Pattern.compile("^[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)+$");
        final Matcher matcher = pattern.matcher(mail);

        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    /**
     * @param dateString
     * @return true si la date est strictement au bon format et correspond bien au calendrier de la timeZone sinon false
     */
    public static Boolean verifDate(final String dateString) {

        final Pattern pattern = Pattern.compile("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$");
        final Matcher matcher = pattern.matcher(dateString);
        if (!matcher.matches()) {
            return false;
        }

        // dateFormat correspond au pattern
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        // date en String du calendrier qu'on convertit en date de calendrier => dateString qui est le param�tre de la m�thode
        try {
            final Date date = dateFormat.parse(dateString);

            // on instancie un calendrier!!
            final Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

        } catch (final ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * permet de verifier que le nombre est bien un entier positif
     * 
     * @param number
     * @return true si le nombre est strictement au bon format
     */
    public static boolean verifNombre(final String number) {
        return number.matches("\\d+");
    }

    /**
     * permet de v�rifier que le prix est bien un nombre d�cimal positif, contenant une c�sure tous les 3 chiffres <br>
     * et ne commen�ant pas par z�ro
     * 
     * @param number
     * @return true si le Prix est strictement au bon format
     */
    public static boolean verifPrix(final String number) {
        return number.matches("^[1-9]{1}[0-9]{0,2}( \\d{3})*(,\\d{1,2})$");
    }
}
