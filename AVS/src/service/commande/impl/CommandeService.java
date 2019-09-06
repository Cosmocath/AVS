/**
 * 
 */
package service.commande.impl;

import java.util.List;

import persistance.commande.beanDo.CommandeDo;
import persistance.commande.dao.ICommandeDao;
import presentation.commande.beanDto.CommandeDto;
import service.commande.CommandeMapper;
import service.commande.ICommandeService;
import util.Factory;

/**
 * Implémentation du service pour gérer les commandes
 * 
 * @author Administrateur
 *
 */
public class CommandeService implements ICommandeService {

    private CommandeService() {
        //empty Constructeur
    }

    @Override
    public List<CommandeDto> findAllCommande(final int idUtilisateur) {
        final ICommandeDao iCommandeDao = Factory.getInstance(ICommandeDao.class);
        final List<CommandeDo> listeCommandeDo = (iCommandeDao).findAllCommandeDo(idUtilisateur);
        return CommandeMapper.mapToListDto(listeCommandeDo);
    }

}
