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
     * Permet de faire appel à la couche persitance afin de rechercher toutes les Commandes d'un utilisateur
     * 
     * @return la liste de commande d'un Utilisateur
     */
    List<CommandeDto> findAllCommande(final int idUtilisateur);

}
