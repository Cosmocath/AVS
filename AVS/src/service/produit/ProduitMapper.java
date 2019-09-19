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
        return produitDto.buildProduitDto(produitDo.getId(), produitDo.getDesignation(), produitDo.getReference(), produitDo.getDescription(), produitDo.getPrix(), produitDo.getImage(),
                        produitDo.getNumeroVersion(), produitDo.getActif());
    }

    /**
     * Permet de mapper un ProduitDto en ProduitDo
     * 
     * @param produitDto
     * @return produitDo
     */
    public static ProduitDo mapToDo(final ProduitDto produitDto) {
        final ProduitDo produitDo = new ProduitDo();
        return produitDo.buildProduitDo(produitDto.getId(), produitDto.getDesignation(), produitDto.getReference(), produitDto.getDescription(), produitDto.getPrix(), produitDto.getImage(),
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
        produitDo.setPrix(produitDto.getPrix());
        // TODO RKU : gérer l'image
        //produitDo.setImage(produitDto.getImage());
        produitDo.setImage("null");
        produitDo.setNumeroVersion(produitDto.getNoVersion());
        produitDo.setActif(true);
        return produitDo;
    }
}
