package service.panier;

import presentation.panier.beanDto.PanierDto;

/**
 * @author Nora LIFERKI
 *
 *         Interface permettant de d�clarer les m�thodes du business service PanierService
 */
public interface IPanierService {

    /**
     * @param panierDto
     * @return
     */
    PanierDto remisePanier(final PanierDto panierDto);
}
