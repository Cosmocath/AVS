/**
 * 
 */
package service.commande;

import java.util.List;

import presentation.commande.beanDto.CommandeDto;

/**
 * Interface permettant de déclarer les méthodes du business service CommandeService
 * 
 * @author Administrateur
 *
 */
public interface ICommandeService {

    /**
     * Permet de faire appel à la couche persitance afin de rechercher toutes les Commandes d'un utilistaeur
     * 
     * @return
     */
    List<CommandeDto> findAllChat(final int id_Utilisateur);

}
