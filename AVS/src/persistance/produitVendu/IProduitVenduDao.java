package persistance.produitVendu;

import persistance.produitVendu.beanDo.ProduitVenduDo;

/**
 * Gestion de la persistance de ProduitVendu
 * 
 * @author Rodolphe
 *
 */
public interface IProduitVenduDao {

    /**
     * Permet de conna�tre la derni�re version du produit faisant partie d'une commande
     * 
     * @param idProduitHistorise : le produit que l'on s'appr�te � ins�rer dans une nouvelle commande
     * @return la derni�re version du ProduitVendu correspondant au produit pass� en param�tre
     */
    ProduitVenduDo findProduitVenduByIdProduitHistorise(final int idProduitHistorise);
}
