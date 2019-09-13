/**
 * 
 */
package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Rodolphe
 *
 */
class ConversionUtilTest {

    /**
     * Test method for {@link util.ConversionUtil#convertDoubleCommaToDot(java.lang.String)}.
     */
    @Test
    void testConvertDoubleCommaToDot() {
        assertEquals(1.75, ConversionUtil.convertDoubleCommaToDot("1,75"));
        assertEquals(1.75, ConversionUtil.convertDoubleCommaToDot("1.75"));
        assertNull( ConversionUtil.convertDoubleCommaToDot(""));
        assertNull( ConversionUtil.convertDoubleCommaToDot(null));
    }

}
