package service.commande;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import persistance.commande.beanDo.CommandeDo;
import persistance.commande.beanDo.CommandeProduitDo;
import presentation.commande.beanDto.CommandeDto;
import presentation.commande.beanDto.CommandeProduitDto;
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
        final double montantMoinsRemise = (commandeDo.getMontantSansRemise() - commandeDo.getRemise());
        final String montant = df.format(montantMoinsRemise);
        Set<CommandeProduitDo> setComm = commandeDo.getCommandeProduitSet();

        Map<CommandeProduitDto, Integer> mapComm = new HashMap<>();

        for (CommandeProduitDo comm : setComm) {
            //TODO mapper CommandeProduitDo
            //            mapComm.put(comm, comm.getQuantite());
        }

        return CommandeDto.build(commandeDo.getIdUtilisateur(), commandeDo.getIdCommande(), commandeDo.getNumeroCommande(), FormatUtil.convertirDateToString(commandeDo.getDateCommande()), montant,
                        commandeDo.getRemise(), commandeDo.getMontantSansRemise());
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
