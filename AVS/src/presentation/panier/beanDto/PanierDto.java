package presentation.panier.beanDto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import presentation.produit.beanDto.ProduitDto;

/**
 * PanierDto couche presentation pour l'ecran
 * 
 * @author Administrateur
 *
 */
public class PanierDto implements Serializable {

    /**
     * 
     */
    private static final long             serialVersionUID  = -1691544355678461733L;

    //pas d'idPanier car Objet non persisté

    private Integer                       quantiteTotale    = 0;
    private String                        totalAvantRemise  = "0,00";
    private String                        remise            = "0,00";
    private String                        totalApresRemise  = "0,00";

    //map de produit par rapport à leur qté et leur prix
    private Map<ProduitDto, QuantitePrix> mapDesProduitsQte = new HashMap<>();

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
     * @return the totalAvantRemise
     */
    public String getTotalAvantRemise() {
        return totalAvantRemise;
    }

    /**
     * @param totalAvantRemise the totalAvantRemise to set
     */
    public void setTotalAvantRemise(final String totalAvantRemise) {
        this.totalAvantRemise = totalAvantRemise;
    }

    /**
     * @return the remise
     */
    public String getRemise() {
        return remise;
    }

    /**
     * @param remise the remise to set
     */
    public void setRemise(final String remise) {
        this.remise = remise;
    }

    /**
     * @return the totalApresRemise
     */
    public String getTotalApresRemise() {
        return totalApresRemise;
    }

    /**
     * @param totalApresRemise the totalApresRemise to set
     */
    public void setTotalApresRemise(final String totalApresRemise) {
        this.totalApresRemise = totalApresRemise;
    }

    /**
     * @return the mapDesProduitsQte
     */
    public Map<ProduitDto, QuantitePrix> getMapDesProduitsQte() {
        return mapDesProduitsQte;
    }

    /**
     * @param mapDesProduitsQte the mapDesProduitsQte to set
     */
    public void setMapDesProduitsQte(final Map<ProduitDto, QuantitePrix> mapDesProduitsQte) {
        this.mapDesProduitsQte = mapDesProduitsQte;
    }

    /**
     * Classe interne pour la quantite et le prix d'un produit
     * 
     * @author Administrateur
     *
     */
    public static class QuantitePrix {

        private Integer quantite       = 0;
        private String  prixParProduit = "";

        /**
         * Permet de mettre à jour la quantite
         * 
         * @param quantite
         * @return
         */
        public QuantitePrix ajouterQuantite(final int quantite) {
            this.quantite += quantite;
            return this;
        }

        /**
         * Permet de mettre à jour le prix
         * 
         * @param prix
         * @return
         */
        public QuantitePrix updatePrix(final String prix) {
            this.prixParProduit = prix;
            return this;
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

        /**
         * @return the prixParProduit
         */
        public String getPrixParProduit() {
            return prixParProduit;
        }

        /**
         * @param prixParProduit the prixParProduit to set
         */
        public void setPrixParProduit(final String prixParProduit) {
            this.prixParProduit = prixParProduit;
        }

    }

}
