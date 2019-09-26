package presentation.produitVendu.beanDto;

/**
 * @author Valentin
 *
 */
public class ProduitVenduDto {

    private Integer idProduitHistorise;
    private String  reference;
    private String  prix;
    private String  image;

    /**
     * Constructeur
     */
    public ProduitVenduDto() {
        // empty method
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
     * @return the prix
     */
    public String getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(final String prix) {
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

}
