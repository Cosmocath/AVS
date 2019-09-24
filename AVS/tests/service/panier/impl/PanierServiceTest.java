/**
 * 
 */
package service.panier.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import persistance.factory.HibernateFactory;
import presentation.panier.beanDto.PanierDto;
import service.panier.IPanierService;
import util.factory.Factory;

/**
 * @author Administrateur
 *
 */
class PanierServiceTest {

    public static SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    /**
     * Test method for {@link service.panier.impl.PanierService#addProduitPanier(presentation.panier.beanDto.PanierDto, int)}.
     */
    @Test
    void testAddProduitPanier() {
        final IPanierService iPanierService = Factory.getInstance(IPanierService.class);
        assertNotNull(iPanierService);
        PanierDto panierDto = new PanierDto();
        panierDto = iPanierService.addProduitPanier(panierDto, 12);
        assertEquals(1, panierDto.getMapDesProduitsQte().size());
        assertEquals(Double.valueOf(30.0), panierDto.getTotalAvantRemise());
    }
}
