package service.panier.impl;

import presentation.panier.beanDto.PanierDto;
import service.panier.IPanierService;

/**
 * @author Nora LIFERKI
 *
 */
public class PanierService implements IPanierService {
    private static final double REMISE                = 0.9;
    private static final double QUANTITE_AVANT_REMISE = 5.0;
    private static final double SEUIL_REMISE          = 100.0;

    private PanierService() {
        //Empty Constructeur
    }

    @Override
    public PanierDto remisePanier(final PanierDto panierDto) {
        if (panierDto.getQuantiteTotale() > QUANTITE_AVANT_REMISE && panierDto.getTotalAvantRemise() >= SEUIL_REMISE) {
            panierDto.setTotalApresRemise(panierDto.getTotalAvantRemise() * REMISE);
            panierDto.setRemise(panierDto.getTotalApresRemise() - panierDto.getTotalAvantRemise());
            return panierDto;
        }

        return panierDto;
    }
}
