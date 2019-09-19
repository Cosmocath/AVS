/**
 * 
 */
package util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import util.cryptage.MD5Encryption;

/**
 * @author Administrateur
 *
 */
class MD5EncryptionTest {

    /**
     * Test method for {@link util.cryptage.MD5Encryption#encrypt(java.lang.String)}.
     */
    @Test
    void testEncrypt() {
        assertEquals("7f9e4e8d6bdfa6da8ed7c73bb882cdaa", MD5Encryption.encrypt("Mdp1531"));
        assertEquals("a32b814d73b6364fe0d8d7b0d8050ba9", MD5Encryption.encrypt("54^ç3?@é"));
        assertEquals("3215f290480cb4c09d2c1ab5cc222376", MD5Encryption.encrypt("543.Méad!"));
        assertNotEquals("543.Méad!", MD5Encryption.encrypt("3215f290480cb4c09d2c1ab5cc222376"));
        assertNotEquals("a32b814d73b6364fe0d8d7b0d8050ba8", MD5Encryption.encrypt("54^ç3?@é"));
    }

}
