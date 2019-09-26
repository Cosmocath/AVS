package persistance.commande.dao;

import java.util.List;

import persistance.commande.beanDo.CommandeDo;

/**
 * Interface CommandeDao
 * 
 * @author Administrateur
 *
 */
public interface ICommandeDao {

    /**
     * Permet de retrouver toutes les commandes d'un utilisateur
     * 
     * @param id_Utilisateur
     * @return la liste des commandes
     */
    List<CommandeDo> findAllCommandeDo(final int idUtilisateur);

    /**
     * Permet de retrouver une commande
     * 
     * @param idCommande
     * @return une commande
     */
    CommandeDo findById(final Integer idCommande);

}
