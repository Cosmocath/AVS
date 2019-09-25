/**
 * 
 */
package persistance.commande.beanDo;

/**
 * Représentation d'un produitVendu dans la base de donnée
 * 
 * @author Valentin
 *
 */
public class ProduitVenduDo {

    private Integer idProduitVendu;
    private String  designation;
    private String  reference;
    private String  description;
    private double  prix;
    private String  image;
    private Integer numeroVersion;
    private Integer idProduitHistorise;

    /**
     * 
     */
    public ProduitVenduDo() {
        // empty method
    }

    /**
     * @return the idProduitVendu
     */
    public Integer getIdProduitVendu() {
        return idProduitVendu;
    }

    /**
     * @param idProduitVendu the idProduitVendu to set
     */
    public void setIdProduitVendu(final Integer idProduitVendu) {
        this.idProduitVendu = idProduitVendu;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(final String designation) {
        this.designation = designation;
    }

    /**
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(final String reference) {
        this.reference = reference;
    }

    /**
     * @return the prixUnitaire
     */
    public double getPrix() {
        return prix;
    }

    /**
     * @param prixUnitaire the prixUnitaire to set
     */
    public void setPrix(final double prix) {
        this.prix = prix;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(final String image) {
        this.image = image;
    }

    /**
     * @return the idProduitHistorise
     */
    public Integer getIdProduitHistorise() {
        return idProduitHistorise;
    }

    /**
     * @param idProduitHistorise the idProduitHistorise to set
     */
    public void setIdProduitHistorise(final Integer idProduitHistorise) {
        this.idProduitHistorise = idProduitHistorise;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @return the numeroVersion
     */
    public Integer getNumeroVersion() {
        return numeroVersion;
    }

    /**
     * @param numeroVersion the numeroVersion to set
     */
    public void setNumeroVersion(final Integer numeroVersion) {
        this.numeroVersion = numeroVersion;
    }

    
}
