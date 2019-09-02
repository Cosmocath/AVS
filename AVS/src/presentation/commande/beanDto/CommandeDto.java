/**
 * 
 */
package presentation.commande.beanDto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrateur
 *
 */
public class CommandeDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 542346324375306389L;

    private Integer           idUtilisateur;
    private Integer           idCommande;
    private Integer           numeroCommande;
    private Date              date;
    // montant avec remise a calculers
    private Integer           montant;

    /**
     * 
     */
    public CommandeDto() {
        // empty method
    }

    
    
    /**
     * @return the idUtilisateur
     */
    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    /**
     * @param idUtilisateur the idUtilisateur to set
     */
    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    /**
     * @return the idCommande
     */
    public Integer getIdCommande() {
        return idCommande;
    }

    /**
     * @param idCommande the idCommande to set
     */
    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    /**
     * @return the numeroCommande
     */
    public Integer getNumeroCommande() {
        return numeroCommande;
    }

    /**
     * @param numeroCommande the numeroCommande to set
     */
    public void setNumeroCommande(Integer numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the montant
     */
    public Integer getMontant() {
        return montant;
    }

    /**
     * @param montant the montant to set
     */
    public void setMontant(Integer montant) {
        this.montant = montant;
    }

}
