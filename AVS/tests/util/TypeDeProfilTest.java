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
class TypeDeProfilTest {

    @Test
    void test() {
        System.out.println(TypeDeProfil.ADMINISTRATEUR.getNomBD());
        System.out.println("admin : "  + TypeDeProfil.getValue("admin"));
        System.out.println("client : "  + TypeDeProfil.getValue("client"));
        assertNull(TypeDeProfil.getValue("cli"));
    }

}
