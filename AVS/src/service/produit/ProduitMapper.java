package service.produit;

import java.util.ArrayList;
import java.util.List;

import persistance.bean.ChatDo;
import persistance.produit.beanDo.ProduitDo;
import presentation.bean.ChatDto;
import presentation.produit.beanDto.ProduitDto;

/**
 * Mapper Dto/Do bidirectionnel pour un Chat
 * 
 * @author xsint
 *
 */
public class ProduitMapper {

    /**
     * Permet de mapper un ProduitDo en ProduitDto
     * 
     * @param chatDo
     * @return
     */
    public static ProduitDto mapToDto(final ProduitDo produitDo) {
        return ProduitDto.build(produitDo.getId(), produitDo.getDesignation(), produitDo.getReference(),  produitDo.getDescription(),produitDo.getPrix(),produitDo.getImage(),produitDo.getNumero_version(),produitDo.getActif());
    }

//    /**
//     * Permet de mapper un ChatDto en ChatDo
//     * 
//     * @param chatDto
//     * @return
//     */
//    public static ProduitDo mapToDo(final ProduitDto produitDto) {
//        final ProduitDo produitDo = new ProduitDo();
//        produitDo.setId(produitDto.getId());
//        produitDo.setDescription(produitDto.getDescription());
//
//        return produitDo;
//    }

    /**
     * Permet de mapper une liste de ChatDo en liste de ChatDto
     * 
     * @param listeChatDo
     * @return
     */
    public static List<ProduitDto> mapToListDto(final List<ProduitDo> listeProduitDo) {
        final List<ProduitDto> listeProduitDto = new ArrayList<>();
        for (final ProduitDo produitDo : listeProduitDo) {
            listeProduitDto.add(mapToDto(produitDo));
        }
        return listeProduitDto;
    }

}
