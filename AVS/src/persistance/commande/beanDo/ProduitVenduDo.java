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
    private double  prixUnitaire;
    private String  image;
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
    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    /**
     * @param prixUnitaire the prixUnitaire to set
     */
    public void setPrixUnitaire(final double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
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

}
