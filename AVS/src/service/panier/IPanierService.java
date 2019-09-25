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
     * @return permet de calculer la remise sur le panier quand le seuil de 6 articles � 100 euros est atteint
     */
    PanierDto remisePanier(final PanierDto panierDto);
}
