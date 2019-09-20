/**
 * 
 */
package presentation.panier.beanDto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import presentation.produit.beanDto.ProduitDto;

/**
 * @author Administrateur
 *
 */
public class PanierDto implements Serializable {

    /**
     * 
     */
    private static final long        serialVersionUID  = -1691544355678461733L;

    //pas d'idPanier car Objet non persist�

    private Integer                  quantiteTotale;
    private Double                   prixTotal;
    private Double                   totalAvantRemise;
    private Double                   remise;
    private Double                   totalApresRemise;

    //map de produit par rapport � leur qt� 
    private Map<ProduitDto, Integer> mapDesProduitsQte = new HashMap<ProduitDto, Integer>();

    /**
     * Construsteur par defaut
     */
    public PanierDto() {
        //Empty method
    }

    /**
     * @return the quantiteTotale
     */
    public Integer getQuantiteTotale() {
        return quantiteTotale;
    }

    /**
     * @param quantiteTotale the quantiteTotale to set
     */
    public void setQuantiteTotale(final Integer quantiteTotale) {
        this.quantiteTotale = quantiteTotale;
    }

    /**
     * @return the prixTotal
     */
    public Double getPrixTotal() {
        return prixTotal;
    }

    /**
     * @param prixTotal the prixTotal to set
     */
    public void setPrixTotal(final Double prixTotal) {
        this.prixTotal = prixTotal;
    }

    /**
     * @return the totalAvantRemise
     */
    public Double getTotalAvantRemise() {
        return totalAvantRemise;
    }

    /**
     * @param totalAvantRemise the totalAvantRemise to set
     */
    public void setTotalAvantRemise(final Double totalAvantRemise) {
        this.totalAvantRemise = totalAvantRemise;
    }

    /**
     * @return the remise
     */
    public Double getRemise() {
        return remise;
    }

    /**
     * @param remise the remise to set
     */
    public void setRemise(final Double remise) {
        this.remise = remise;
    }

    /**
     * @return the totalApresRemise
     */
    public Double getTotalApresRemise() {
        return totalApresRemise;
    }

    /**
     * @param totalApresRemise the totalApresRemise to set
     */
    public void setTotalApresRemise(final Double totalApresRemise) {
        this.totalApresRemise = totalApresRemise;
    }

    /**
     * @return the mapDesProduitsQte
     */
    public Map<ProduitDto, Integer> getMapDesProduitsQte() {
        return mapDesProduitsQte;
    }

    /**
     * @param mapDesProduitsQte the mapDesProduitsQte to set
     */
    public void setMapDesProduitsQte(final Map<ProduitDto, Integer> mapDesProduitsQte) {
        this.mapDesProduitsQte = mapDesProduitsQte;
    }

}
