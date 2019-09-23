package service.commande;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import persistance.commande.beanDo.CommandeDo;
import presentation.commande.beanDto.CommandeDto;
import util.tools.FormatUtil;

/**
 * Mapper Dto/Do pour une commande
 * 
 * @author Administrateur
 *
 */
public class CommandeMapper {

    /**
     * Permet de mapper une commandeDo en commandeDto
     * 
     * @param commandeDo
     * @return commandeDto
     */
    public static CommandeDto mapToDto(final CommandeDo commandeDo) {
        final DecimalFormat df = new DecimalFormat("0.00");
        final String montant = df.format(commandeDo.getMontantSansRemise());
        return CommandeDto.build(commandeDo.getIdUtilisateur(), commandeDo.getIdCommande(), commandeDo.getNumeroCommande(), FormatUtil.convertirDateToString(commandeDo.getDateCommande()), montant);
    }

    /**
     * Permet de mapper une liste de CommandeDo en liste de CommandeDto
     * 
     * @param listeCommandeDo
     * @return listeCommandeDto
     */
    public static List<CommandeDto> mapToListDto(final List<CommandeDo> listeCommandeDo) {
        final List<CommandeDto> listeCommandeDto = new ArrayList<>();
        for (final CommandeDo commandeDo : listeCommandeDo) {
            listeCommandeDto.add(mapToDto(commandeDo));
        }
        return listeCommandeDto;
    }
}
