package service.panier.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import presentation.panier.beanDto.PanierDto;
import service.panier.IPanierService;
import util.factory.Factory;

/**
 * @author Administrateur
 *
 */
class PanierServiceTest {

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
