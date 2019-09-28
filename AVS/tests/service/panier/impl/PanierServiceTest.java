package service.panier.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import persistance.factory.HibernateFactory;
import presentation.panier.beanDto.PanierDto;
import presentation.produit.beanDto.ProduitDto;
import service.panier.IPanierService;
import service.produit.IProduitService;
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
     * Test method for {@link service.panier.impl.PanierService#diminuerProduitPanier(presentation.panier.beanDto.PanierDto, int)}.
     */
    @Test
    void testDiminuerProduitPanier() {
        final PanierDto panierDto = new PanierDto();
        final IPanierService iPanierService = Factory.getInstance(IPanierService.class);
        final PanierDto.QuantitePrix quantitePrix = new PanierDto.QuantitePrix();
        final IProduitService iProduitService = Factory.getInstance(IProduitService.class);
        iPanierService.addProduitPanier(panierDto, 12);
        iPanierService.addProduitPanier(panierDto, 12);
        iPanierService.addProduitPanier(panierDto, 14);
        iPanierService.addProduitPanier(panierDto, 15);
        iPanierService.addProduitPanier(panierDto, 16);
        iPanierService.addProduitPanier(panierDto, 17);
        iPanierService.addProduitPanier(panierDto, 17);
        iPanierService.addProduitPanier(panierDto, 17);
        iPanierService.addProduitPanier(panierDto, 18);
        
        Assertions.assertNotNull(panierDto);
        Assertions.assertNotNull(panierDto.getMapDesProduitsQte());
        Assertions.assertEquals(6, panierDto.getQuantiteTotale());
        Assertions.assertEquals("365,00", panierDto.getTotalAvantRemise());
        Assertions.assertEquals("36,50", panierDto.getRemise());
        Assertions.assertEquals("328,50", panierDto.getTotalApresRemise());
        
        Assertions.assertEquals(3, panierDto.getMapDesProduitsQte().get(iProduitService.getProduitById(17)).getQuantite());
        iPanierService.diminuerProduitPanier(panierDto, 17);
        Assertions.assertEquals(2, panierDto.getMapDesProduitsQte().get(iProduitService.getProduitById(17)).getQuantite());
        Assertions.assertEquals("340,00", panierDto.getTotalAvantRemise());
        Assertions.assertEquals("34,00", panierDto.getRemise());
        Assertions.assertEquals("306,00", panierDto.getTotalApresRemise());
        Assertions.assertEquals(6, panierDto.getQuantiteTotale());
        
        Assertions.assertEquals(1, panierDto.getMapDesProduitsQte().get(iProduitService.getProduitById(14)).getQuantite());
        iPanierService.diminuerProduitPanier(panierDto, 14);
        Assertions.assertNull(panierDto.getMapDesProduitsQte().get(iProduitService.getProduitById(14)));
        Assertions.assertEquals("280,00", panierDto.getTotalAvantRemise());
        Assertions.assertEquals("0,00", panierDto.getRemise());
        Assertions.assertEquals("280,00", panierDto.getTotalApresRemise());
        Assertions.assertEquals(5, panierDto.getQuantiteTotale());
        
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
        Assertions.assertEquals("0,00", panierDto.getRemise());

        panierDto.setQuantiteTotale(4);
        panierDto.setTotalAvantRemise("100,00");
        panierDto.setTotalApresRemise("100,00");
        iPanierService.remisePanier(panierDto);
        Assertions.assertEquals("100,00", panierDto.getTotalApresRemise());
        Assertions.assertEquals("0,00", panierDto.getRemise());

        panierDto.setQuantiteTotale(6);
        panierDto.setTotalAvantRemise("200,00");
        panierDto.setTotalApresRemise("200,00");
        iPanierService.remisePanier(panierDto);
        Assertions.assertEquals("180,00", panierDto.getTotalApresRemise());
        Assertions.assertEquals("20,00", panierDto.getRemise());

    }

    /**
     * Test method for {@link service.panier.impl.PanierService#deleteProduitPanier(presentation.panier.beanDto.PanierDto, int)}.
     */
    @Test
    void testDeleteProduitPanier() {
        final IPanierService iPanierService = Factory.getInstance(IPanierService.class);
        assertNotNull(iPanierService);
        PanierDto panierDto = new PanierDto();
        panierDto = iPanierService.addProduitPanier(panierDto, 12);
        panierDto = iPanierService.addProduitPanier(panierDto, 13);
        assertEquals(2, panierDto.getMapDesProduitsQte().size());
        panierDto = iPanierService.deleteProduitPanier(panierDto, 12);
        assertEquals("20,00", panierDto.getTotalAvantRemise());
        assertEquals(1, panierDto.getMapDesProduitsQte().size());
    }

    /**
     * Test method for {@link service.panier.impl.PanierService#viderPanierDto(presentation.panier.beanDto.PanierDto)}.
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
