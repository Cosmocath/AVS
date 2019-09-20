package util.conversionUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import util.ConversionUtil;

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
        // TODO XSI : ajouter des tests > 1000
        assertNull(ConversionUtil.convertDoubleCommaToDot(""));
        assertNull(ConversionUtil.convertDoubleCommaToDot(null));
    }

}
