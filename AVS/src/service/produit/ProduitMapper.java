package service.produit;

import java.util.ArrayList;
import java.util.List;

import persistance.produit.beanDo.ProduitDo;
import presentation.produit.beanDto.ProduitDto;

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
        final ProduitDto produitDto = new ProduitDto();
        produitDto.setId(produitDo.getId());
        produitDto.setDesignation(produitDo.getDesignation());
        produitDto.setReference(produitDo.getReference());
        produitDto.setDescription(produitDo.getDescription());
        produitDto.setPrix(produitDo.getPrix());
        produitDto.setImage(produitDo.getImage());
        produitDto.setNoVersion(produitDo.getNumeroVersion());
        produitDto.setActif(produitDo.getActif());

        return produitDto;
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
}