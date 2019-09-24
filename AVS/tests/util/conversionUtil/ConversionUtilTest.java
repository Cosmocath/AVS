package util.conversionUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import util.tools.ConversionUtil;

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
        // TODO : changer le nom
        assertEquals("1.75", ConversionUtil.convertStringCommaToDot("1,75"));
        assertEquals("1.75", ConversionUtil.convertStringCommaToDot("1.75"));
        assertEquals("1500", ConversionUtil.convertStringCommaToDot("1500"));
        assertEquals("12000", ConversionUtil.convertStringCommaToDot("12000"));
        assertEquals("15000.19", ConversionUtil.convertStringCommaToDot("15000.19"));
        assertNull(ConversionUtil.convertStringCommaToDot(""));
        assertNull(ConversionUtil.convertStringCommaToDot(null));
    }

}
