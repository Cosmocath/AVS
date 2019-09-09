package presentation.produit.beanDto;

import java.io.Serializable;

/**
 * ProduitDto couche presentation pour l'�cran
 * 
 * @author Catherine Hermary
 *
 */
public class ProduitDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 7637214908602744909L;

    private Integer           id;
    private String            designation;
    private Integer           reference;
    private String            description;
    private double            prix;
    private String            image;
    private int               noVersion;
    private boolean           actif;

    /**
     * Constructeur
     * 
     */
    public ProduitDto() {
        // empty constructor
    }


    /**
     * Builder pour le Dto
     * 
     * @param id
     * @param designation
     * @param reference
     * @param description
     * @param prix
     * @param image
     * @param noVersion
     * @return le produitDto initialis�
     */
    public static ProduitDto build(final Integer id, final String designation, final Integer reference, final String description, final double prix, final String image, final int noVersion) {
        final ProduitDto produitDto = new ProduitDto();
        produitDto.setId(id);
        produitDto.setDesignation(designation);
        produitDto.setReference(reference);
        produitDto.setDescription(description);
        produitDto.setPrix(prix);
        produitDto.setImage(image);
        produitDto.setNoVersion(noVersion);
        return produitDto;
    }


    public static ProduitDto build(final String designation, final Integer reference, final String description, final double prix, final String image, final int noVersion) {
        return build(null, designation, reference, description, prix, image, noVersion);
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
     * @return the noVersion
     */
    public int getNoVersion() {
        return noVersion;
    }

    /**
     * @param noVersion the noVersion to set
     */
    public void setNoVersion(final int noVersion) {
        this.noVersion = noVersion;
    }

    /**
     * @return the actif
     */
    public boolean isActif() {
        return actif;
    }

    /**
     * @param actif the actif to set
     */
    public void setActif(final boolean actif) {
        this.actif = actif;
    }

}
