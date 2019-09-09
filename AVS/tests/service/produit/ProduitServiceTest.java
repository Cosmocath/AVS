/**
 * 
 */
package service.produit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import presentation.produit.beanDto.ProduitDto;
import util.Factory;

/**
 * @author Rodolphe
 *
 */
class ProduitServiceTest {

    /**
     * Test method for {@link service.produit.impl.ProduitService#findAllProduitOrderBy(util.OrderBy)}.
     */
    @Test
    void testFindAllProduitOrderBy() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#create(presentation.produit.beanDto.ProduitDto)}.
     */
    @Test
    void testCreate() {
        final IProduitService iProduitService = Factory.getInstance(IProduitService.class);
        assertNotNull(iProduitService);
        // référence déjà présente en base
        final ProduitDto produitDtoNew = new ProduitDto();
        produitDtoNew.setDesignation("designationProduit123456");
        produitDtoNew.setDescription("description produit 123456");
        produitDtoNew.setImage("chemin image 123456");
        produitDtoNew.setPrix(11.6);
        produitDtoNew.setReference(123456);
        produitDtoNew.setActif(true);
        produitDtoNew.setNoVersion(1);
        assertNull(iProduitService.create(produitDtoNew));
        final ProduitDto produitDtoNew2 = new ProduitDto();
        produitDtoNew2.setDesignation("designationProduit123456");
        produitDtoNew2.setDescription("description produit 123456");
        produitDtoNew2.setImage("chemin image 123456");
        produitDtoNew2.setPrix(11.6);
        produitDtoNew2.setReference(3001);
        produitDtoNew2.setActif(true);
        produitDtoNew2.setNoVersion(1);
        assertNotNull(iProduitService.create(produitDtoNew2));
    }

}
