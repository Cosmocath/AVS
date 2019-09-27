package presentation.panier.beanDto;

import java.io.Serializable;

/**
 * Informations sur l'utilisateur qui réalise une commande
 * 
 * @author Rodolphe
 *
 */
public class CommandeInfoDto implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 5456347500549851141L;
    
    private String userId;
    private String adresseLivraison;
    private String adresseFacturation;
    
    /**
     * Constructeur par défaut
     */
    public CommandeInfoDto() {
        // Empty method
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(final String userId) {
        this.userId = userId;
    }

    /**
     * @return the adresseLivraison
     */
    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    /**
     * @param adresseLivraison the adresseLivraison to set
     */
    public void setAdresseLivraison(final String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    /**
     * @return the adresseFacturation
     */
    public String getAdresseFacturation() {
        return adresseFacturation;
    }

    /**
     * @param adresseFacturation the adresseFacturation to set
     */
    public void setAdresseFacturation(final String adresseFacturation) {
        this.adresseFacturation = adresseFacturation;
    }
    

}
