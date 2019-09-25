package service.panier.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
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
        // TODO XSI : compléter les tests
    }

    /**
     * Test method for {@link service.panier.impl.PanierService#remisePanier(presentation.panier.beanDto.PanierDto)}.
     */
    @Test
    void testRemisePanier() {
        final PanierDto panierDto = new PanierDto();
        panierDto.setQuantiteTotale(6);
        panierDto.setTotalAvantRemise(10.0);
        panierDto.setTotalApresRemise(10.0);
        final IPanierService iPanierService = Factory.getInstance(IPanierService.class);
        iPanierService.remisePanier(panierDto);
        Assertions.assertEquals(Double.valueOf(10.0), panierDto.getTotalApresRemise());

        panierDto.setQuantiteTotale(4);
        panierDto.setTotalAvantRemise(100.0);
        panierDto.setTotalApresRemise(100.0);
        iPanierService.remisePanier(panierDto);
        Assertions.assertEquals(Double.valueOf(100.0), panierDto.getTotalApresRemise());

        panierDto.setQuantiteTotale(6);
        panierDto.setTotalAvantRemise(200.0);
        panierDto.setTotalApresRemise(200.0);
        iPanierService.remisePanier(panierDto);
        Assertions.assertEquals(Double.valueOf(180.0), panierDto.getTotalApresRemise());

    }

}
