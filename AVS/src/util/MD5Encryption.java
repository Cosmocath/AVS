/**
 * 
 */
package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Administrateur
 *
 */
public class MD5Encryption {

    /**
     * 
     */
    public MD5Encryption() {
        // empty method
    }

    /**
     * Methode qui prend en parametre une chaine de caractere "motDePasse" et retournera une autre chaine de caratere afin de crypter le mot de passe.
     * 
     * @param mdp
     * @return
     */
    public static String encrypt(final String motDePasse) {
        final StringBuilder sb = new StringBuilder();
        try {
            final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            final byte[] hashInBytes = messageDigest.digest(motDePasse.getBytes(StandardCharsets.UTF_8));

            for (byte b : hashInBytes) {
                sb.append(String.format("%02x", b));
            }

        } catch (NoSuchAlgorithmException algorimthmException) {
            algorimthmException.printStackTrace();
        }
        return sb.toString();

    }
}
