/**
 * 
 */
package service.commande;

import java.util.ArrayList;
import java.util.List;

import persistance.commande.beanDo.CommandeDo;
import presentation.commande.beanDto.CommandeDto;
import util.FormatUtil;

/**
 * Mapper Dto/Do pour une commande
 * 
 * @author Administrateur
 *
 */
public class CommandeMapper {

    /**
     * Permet de mapper une commandeDo en commandeDto
     * @param commandeDo
     * @return
     */
    public static CommandeDto mapToDto(final CommandeDo commandeDo) {
        return CommandeDto.build(commandeDo.getIdUtilisateur(), commandeDo.getIdCommande(), commandeDo.getNumeroCommande(), FormatUtil.convertirDateToString(commandeDo.getDateCommande()),
                        (int) commandeDo.getMontantSansRemise());
    }

    /**
     * Permet de mapper une liste de CommandeDo en liste de CommandeDto
     * 
     * @param listeCommandeDo
     * @return
     */
    public static List<CommandeDto> mapToListDto(final List<CommandeDo> listeCommandeDo) {
        final List<CommandeDto> listeCommandeDto = new ArrayList<>();
        for (final CommandeDo commandeDo : listeCommandeDo) {
            listeCommandeDto.add(mapToDto(commandeDo));
        }
        return listeCommandeDto;
    }
}
