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
     * Permet de connaître la dernière version du produit faisant partie d'une commande
     * 
     * @param idProduitHistorise : le produit que l'on s'apprête à insérer dans une nouvelle commande
     * @return la dernière version du ProduitVendu correspondant au produit passé en paramètre
     */
    ProduitVenduDo findProduitVenduByIdProduitHistorise(final int idProduitHistorise);
}
