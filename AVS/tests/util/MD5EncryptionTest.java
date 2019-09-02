/**
 * 
 */
package util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Administrateur
 *
 */
class MD5EncryptionTest {

    /**
     * Test method for {@link util.MD5Encryption#encrypt(java.lang.String)}.
     */
    @Test
    void testEncrypt() {
        assertEquals("7f9e4e8d6bdfa6da8ed7c73bb882cdaa", MD5Encryption.encrypt("Mdp1531"));
        assertEquals("436a74312305e0b39918d5316e6aa228", MD5Encryption.encrypt("543Mecdc?"));
        assertEquals("654885945669a535c8ec982ee5f15162", MD5Encryption.encrypt("543Méad!"));
        assertNotEquals("543Méad!", MD5Encryption.encrypt("654885945669a535c8ec982ee5f15162"));
    }

}
