package service.panier.impl;

import presentation.panier.beanDto.PanierDto;
import service.panier.IPanierService;

/**
 * @author Nora LIFERKI
 *
 */
public class PanierService implements IPanierService {

    private PanierService() {
        //Empty Constructeur
    }

    /**
     *
     */
    @Override
    public PanierDto remisePanier(PanierDto panierDto) {
        final double remise = 0.9;
        if (panierDto.getQuantiteTotale() > 5 && panierDto.getTotalAvantRemise() >= 100) {
            panierDto.setTotalApresRemise(panierDto.getTotalAvantRemise() * remise);
            return panierDto;
        }

        return null;
    }
}
