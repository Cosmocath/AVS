/**
 * 
 */
package service.commande;

import java.util.List;

import presentation.commande.beanDto.CommandeDto;

/**
 * Interface permettant de d�clarer les m�thodes du business service CommandeService
 * 
 * @author Administrateur
 *
 */
public interface ICommandeService {

    /**
     * Permet de faire appel � la couche persitance afin de rechercher toutes les Commandes d'un utilisateur
     * 
     * @return la liste de commande d'un Utilisateur
     */
    List<CommandeDto> findAllCommande(final int idUtilisateur);

}
