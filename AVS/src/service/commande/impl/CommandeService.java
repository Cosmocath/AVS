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
 * @author Administrateur
 *
 */
public class CommandeService implements ICommandeService {

    private CommandeService() {
        //empty Constructeur
    }

    @Override
    public List<CommandeDto> findAllChat(int id_Utilisateur) {
        final ICommandeDao iCommandeDao = Factory.getInstance(ICommandeDao.class);
        // on pourrait ne pas utiliser cette variable
        final List<CommandeDo> listeCommandeDo = (iCommandeDao).findAllCommandeDo(id_Utilisateur);
        return CommandeMapper.mapToListDto(listeCommandeDo);
    }
}
