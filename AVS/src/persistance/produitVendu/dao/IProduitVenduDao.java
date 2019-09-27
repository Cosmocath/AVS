package persistance.produitVendu.dao;

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
     * @param version : la version du produit recherch�
     * @return le ProduitVendu correspondant au produit pass� en param�treet � la version, null sinon
     */
    ProduitVenduDo findProduitVenduByIdProduitHistoriseAndVersion(final int idProduitHistorise, final int version);
}
