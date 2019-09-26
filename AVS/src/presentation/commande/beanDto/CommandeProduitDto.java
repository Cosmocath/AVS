package presentation.commande.beanDto;

import presentation.produitVendu.beanDto.ProduitVenduDto;

/**
 * @author Valentin
 *
 */
public class CommandeProduitDto {

    private Integer         idCommandeProduit;
    private CommandeDto     commandeDto;
    private ProduitVenduDto produitVenduDto;
    private String          quantite;

    /**
     * Constructeur
     */
    public CommandeProduitDto() {
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
     * @return the commandeDto
     */
    public CommandeDto getCommandeDto() {
        return commandeDto;
    }

    /**
     * @param commandeDto the commandeDto to set
     */
    public void setCommandeDto(final CommandeDto commandeDto) {
        this.commandeDto = commandeDto;
    }

    /**
     * @return the produitVenduDto
     */
    public ProduitVenduDto getProduitVenduDto() {
        return produitVenduDto;
    }

    /**
     * @param produitVenduDto the produitVenduDto to set
     */
    public void setProduitVenduDto(final ProduitVenduDto produitVenduDto) {
        this.produitVenduDto = produitVenduDto;
    }

    /**
     * @return the quantite
     */
    public String getQuantite() {
        return quantite;
    }

    /**
     * @param quantite the quantite to set
     */
    public void setQuantite(final String quantite) {
        this.quantite = quantite;
    }

}
