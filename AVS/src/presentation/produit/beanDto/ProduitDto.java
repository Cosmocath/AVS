/**
 * 
 */
package presentation.produit.beanDto;

import java.io.Serializable;

/**
 * @author Nora Liferki
 *
 */
public class ProduitDto implements Serializable {

    /**
     * Nuléro de série
     * 
     */
    private static final long serialVersionUID = 7637214908602744909L;

    private int               id;
    private String            description;

    /**
     * Constructeur
     */
    public ProduitDto() {
        // empty method
    }

    public ProduitDto initProduit(final int id, final String description) {
        this.id = id;
        this.description = description;
        return this;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final int id) {
        this.id = id;
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

}
