/**
 * 
 */
package persistance.commande.beanDo;

/**
 * Représentation d'une commandeProduit dans la base de donnée
 * 
 * @author Valentin
 *
 */
public class CommandeProduitDo {

    private Integer        idCommandeProduit;
    private Integer        idCommande;
    private ProduitVenduDo produitVendu;
    private Integer        quantite;

    /**
     * 
     */
    public CommandeProduitDo() {
        // empty method
    }

    /**
     * @return the idCommandeProduit
     */
    public Integer getIdCommandeProduit() {
        return idCommandeProduit;
    }

    /**
     * @param idCommandeProduit the idCommandeProduit to set
     */
    public void setIdCommandeProduit(final Integer idCommandeProduit) {
        this.idCommandeProduit = idCommandeProduit;
    }

    /**
     * @return the idCommande
     */
    public Integer getIdCommande() {
        return idCommande;
    }

    /**
     * @param idCommande the idCommande to set
     */
    public void setIdCommande(final Integer idCommande) {
        this.idCommande = idCommande;
    }

    /**
     * @return the produitVendu
     */
    public ProduitVenduDo getProduitVendu() {
        return produitVendu;
    }

    /**
     * @param produitVendu the produitVendu to set
     */
    public void setProduitVendu(final ProduitVenduDo produitVendu) {
        this.produitVendu = produitVendu;
    }

    /**
     * @return the quantite
     */
    public Integer getQuantite() {
        return quantite;
    }

    /**
     * @param quantite the quantite to set
     */
    public void setQuantite(final Integer quantite) {
        this.quantite = quantite;
    }

}
