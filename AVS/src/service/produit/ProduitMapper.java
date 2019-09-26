package service.produit;

import java.util.ArrayList;
import java.util.List;

import persistance.produit.beanDo.ProduitDo;
import presentation.produit.beanDto.ProduitDto;
import util.tools.FormatUtil;

/**
 * Mapper un produitDo en produitDto
 * 
 * @author Nora LIFERKI
 *
 */
public class ProduitMapper {

    /**
     * Permet de mapper un ProduitDo en ProduitDto
     * 
     * @param produitDo
     * @return produitDto
     */
    public static ProduitDto mapToDto(final ProduitDo produitDo) {
        // byte initialisé à vide car image pas traiter à cette endroit pour l'affichage
        final String prixDto = FormatUtil.convertirDoubleToString(produitDo.getPrix());
        return ProduitDto.buildProduitDto(produitDo.getId(), produitDo.getDesignation(), produitDo.getReference(), produitDo.getDescription(), prixDto, produitDo.getImage(),
                        produitDo.getNumeroVersion(), produitDo.getActif(), new byte[0]);
    }

    /**
     * Permet de mapper un ProduitDto en ProduitDo
     * 
     * @param produitDto
     * @return produitDo
     */
    public static ProduitDo mapToDo(final ProduitDto produitDto) {
        final ProduitDo produitDo = new ProduitDo();
        final Double prixDo = FormatUtil.convertirStringToDouble(produitDto.getPrix());
        return produitDo.buildProduitDo(produitDto.getId(), produitDto.getDesignation(), produitDto.getReference(), produitDto.getDescription(), prixDo, produitDto.getImage(),
                        produitDto.getNoVersion(), produitDto.isActif());
    }

    /**
     * Permet de mapper une liste de ProduitDo en liste de ProduitDto
     * 
     * @param listeProduitDo
     * @return listeProduitDto
     */
    public static List<ProduitDto> mapToListDto(final List<ProduitDo> listeProduitDo) {
        final List<ProduitDto> listeProduitDto = new ArrayList<>();
        for (final ProduitDo produitDo : listeProduitDo) {
            listeProduitDto.add(mapToDto(produitDo));
        }
        return listeProduitDto;
    }

    /**
     * Permet de mapper un ProduitDto en ProduitDo
     * 
     * @param produitDto
     * @return le produitDo
     */
    public static ProduitDo mapDtoToDo(final ProduitDto produitDto) {
        final ProduitDo produitDo = new ProduitDo();
        produitDo.setId(produitDto.getId());
        produitDo.setDesignation(produitDto.getDesignation());
        produitDo.setReference(produitDto.getReference());
        produitDo.setDescription(produitDto.getDescription());;
        produitDo.setPrix(FormatUtil.convertirStringToDouble(produitDto.getPrix()));
        produitDo.setImage(produitDto.getImage());
        produitDo.setNumeroVersion(produitDto.getNoVersion());
        produitDo.setActif(true);
        return produitDo;
    }
}
