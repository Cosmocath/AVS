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
import presentation.commande.beanDto.CommandeDto.QuantitePrix;
import presentation.produitVendu.beanDto.ProduitVenduDto;
import service.produitVendu.IProduitVenduService;
import util.factory.Factory;
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
        final IProduitVenduService iProduitVenduService = Factory.getInstance(IProduitVenduService.class);
        final DecimalFormat df = new DecimalFormat("0.00");
        final double montantMoinsRemise = (commandeDo.getMontantSansRemise() - commandeDo.getRemise());
        final String montant = df.format(montantMoinsRemise);
        // On recupère la set de commandeDo
        Set<CommandeProduitDo> setComm = commandeDo.getCommandeProduitSet();
        // On prépare une map 
        Map<ProduitVenduDto, QuantitePrix> mapComm = new HashMap<>();
        // pour chaque commandeProduits dans le set
        for (CommandeProduitDo comm : setComm) {
            // on fait un QuantitePrix on recupère la quantite et on calcul du prixtotal par type de produit et mis en string
            final QuantitePrix quantitePrix = new QuantitePrix();
            quantitePrix.setQuantite(comm.getQuantite());
            quantitePrix.setPrixParTypeProduit(FormatUtil.convertirDoubleToString(comm.getProduitVenduDo().getPrix() * comm.getQuantite()));
            // on met le produitVenduDo de commandeProduit dans la map mapper en Dto et le quantiteprix
            mapComm.put(iProduitVenduService.mapProduitDoToDto(comm.getProduitVenduDo()), quantitePrix);

        }

        return CommandeDto.build(commandeDo.getIdUtilisateur(), commandeDo.getIdCommande(), commandeDo.getNumeroCommande(), FormatUtil.convertirDateToString(commandeDo.getDateCommande()), montant,
                        FormatUtil.convertirDoubleToString(commandeDo.getRemise()), FormatUtil.convertirDoubleToString(commandeDo.getMontantSansRemise()), mapComm, commandeDo.getAdresseLivraison(),
                        commandeDo.getAdresseFacturation());
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
