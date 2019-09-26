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
     * Permet de connaître la dernière version du produit faisant partie d'une commande
     * 
     * @param idProduitHistorise : le produit que l'on s'apprête à insérer dans une nouvelle commande
     * @param version : la version du produit recherché
     * @return le ProduitVendu correspondant au produit passé en paramètreet à la version, null sinon
     */
    ProduitVenduDo findProduitVenduByIdProduitHistoriseAndVersion(final int idProduitHistorise, final int version);
}
