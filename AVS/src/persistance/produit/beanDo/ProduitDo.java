package persistance.produit.beanDo;

/**
 * Repr�sentation du produit pour la BD
 * 
 * @author Nora Liferki
 * 
 *
 */
public class ProduitDo {
    private Integer id;
    private String  designation;
    private Integer reference;
    private String  description;
    private double  prix;
    private String  image;
    private Integer numeroVersion;
    private boolean actif;

    /**
     * Constructeur
     * 
     */
    public ProduitDo() {
        //empty constructeur  
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final Integer id) {
        this.id = id;
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
    public Integer getReference() {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(final Integer reference) {
        this.reference = reference;
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
     * @return the prix
     */
    public double getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
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

    /**
     * @return the actif
     */
    public boolean getActif() {
        return actif;
    }

    /**
     * @param actif the actif to set
     */
    public void setActif(final boolean actif) {
        this.actif = actif;
    }

}