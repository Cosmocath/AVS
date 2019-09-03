/**
 * 
 */
package service.commande.impl;

import java.util.List;
import presentation.commande.beanDto.CommandeDto;
import service.commande.ICommandeService;

/**
 * @author Administrateur
 *
 */
public class CommandeService implements ICommandeService {

    private CommandeService() {
        //empty Constructeur
    }

    @Override
    public List<CommandeDto> findAllChat(int id_Utilisateur) {

        return null;
    }

}
