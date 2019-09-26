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
        assertEquals("40,00", panierDto.getTotalAvantRemise());
        // TODO XSI : compléter les tests
    }

    /**
     * Test method for {@link service.panier.impl.PanierService#remisePanier(presentation.panier.beanDto.PanierDto)}.
     */
    @Test
    void testRemisePanier() {
        final PanierDto panierDto = new PanierDto();
        panierDto.setQuantiteTotale(6);
        panierDto.setTotalAvantRemise("10,00");
        panierDto.setTotalApresRemise("10,00");
        final IPanierService iPanierService = Factory.getInstance(IPanierService.class);
        iPanierService.remisePanier(panierDto);
        Assertions.assertEquals("10,00", panierDto.getTotalApresRemise());

        panierDto.setQuantiteTotale(4);
        panierDto.setTotalAvantRemise("100,00");
        panierDto.setTotalApresRemise("100,00");
        iPanierService.remisePanier(panierDto);
        Assertions.assertEquals("100,00", panierDto.getTotalApresRemise());

        panierDto.setQuantiteTotale(6);
        panierDto.setTotalAvantRemise("200,00");
        panierDto.setTotalApresRemise("200,00");
        iPanierService.remisePanier(panierDto);
        Assertions.assertEquals("180,00", panierDto.getTotalApresRemise());

    }

    /**
     * permet de tester la methode viderPanier
     * 
     */
    @Test
    void testViderPanier() {
        final PanierDto panierDto = new PanierDto();
        final IPanierService iPanierService = Factory.getInstance(IPanierService.class);
        iPanierService.addProduitPanier(panierDto, 12);
        iPanierService.addProduitPanier(panierDto, 15);
        Assertions.assertNotNull(panierDto);
        iPanierService.viderPanierDto(panierDto);
        Assertions.assertEquals(0, panierDto.getQuantiteTotale());
        Assertions.assertEquals("0,00", panierDto.getTotalAvantRemise());
        Assertions.assertEquals("0,00", panierDto.getTotalApresRemise());
        Assertions.assertEquals("0,00", panierDto.getRemise());
        Assertions.assertEquals(0, panierDto.getMapDesProduitsQte().size());

    }

}
