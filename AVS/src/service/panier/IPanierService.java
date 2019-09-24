package service.panier;

import presentation.panier.beanDto.PanierDto;

/**
 * @author Nora LIFERKI
 *
 *         Interface permettant de déclarer les méthodes du business service PanierService
 */
public interface IPanierService {

    /**
     * @param panierDto
     * @return
     */
    PanierDto remisePanier(final PanierDto panierDto);
}
