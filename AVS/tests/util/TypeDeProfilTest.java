package util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import util.enumeration.TypeDeProfil;

/**
 * @author Rodolphe
 *
 */
class TypeDeProfilTest {

    @Test
    void test() {
        assertEquals(TypeDeProfil.ADMINISTRATEUR, TypeDeProfil.getValue("admin"));
        assertEquals(TypeDeProfil.CLIENT, TypeDeProfil.getValue("client"));
        assertEquals(TypeDeProfil.VISITEUR, TypeDeProfil.getValue("visiteur"));
        assertNull(TypeDeProfil.getValue("cli"));
        assertNull(TypeDeProfil.getValue(null));
    }

}
