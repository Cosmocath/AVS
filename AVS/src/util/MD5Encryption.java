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

    public static String encrypt(String mdp) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashInBytes = md.digest(mdp.getBytes(StandardCharsets.UTF_8));

            for (byte b : hashInBytes) {
                sb.append(String.format("%02x", b));
            }

        } catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }
        return sb.toString();

    }
}
