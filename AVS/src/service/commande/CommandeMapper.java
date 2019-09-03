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
 * @author Administrateur
 *
 */
public class CommandeMapper {

    public static CommandeDto mapToDto(final CommandeDo commandeDo) {
        return CommandeDto.build(commandeDo.getId_Utilisateur(), commandeDo.getId_Commande(), commandeDo.getNumero_Commande(), FormatUtil.convertirDateToString(commandeDo.getDate_Commande()), (int)commandeDo.getMontant_Sans_Remise());
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
