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
    private CommandeDo     commandeDo;
    private ProduitVenduDo produitVenduDo;
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
     * @return the commandeDo
     */
    public CommandeDo getCommandeDo() {
        return commandeDo;
    }

    /**
     * @param commandeDo the commandeDo to set
     */
    public void setCommandeDo(final CommandeDo commandeDo) {
        this.commandeDo = commandeDo;
    }

    /**
     * @return the produitVendu
     */
    public ProduitVenduDo getProduitVenduDo() {
        return produitVenduDo;
    }

    /**
     * @param produitVendu the produitVendu to set
     */
    public void setProduitVenduDo(final ProduitVenduDo produitVenduDo) {
        this.produitVenduDo = produitVenduDo;
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
