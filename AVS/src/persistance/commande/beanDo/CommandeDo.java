/**
 * 
 */
package persistance.commande.beanDo;

import java.util.Date;

/**
 * @author Administrateur
 *
 */
public class CommandeDo {
    private int    id_Commande;
    private int    id_Utilisateur;
    private String numero_Commande;
    private Date   date_Commande;
    private double montant_Avec_Remise;

    public CommandeDo() {
        //empty constructeur
    }

    /**
     * @return the id_Commande
     */
    public int getId_Commande() {
        return id_Commande;
    }

    /**
     * @param id_Commande the id_Commande to set
     */
    public void setId_Commande(final int id_Commande) {
        this.id_Commande = id_Commande;
    }

    /**
     * @return the id_Utilisateur
     */
    public int getId_Utilisateur() {
        return id_Utilisateur;
    }

    /**
     * @param id_Utilisateur the id_Utilisateur to set
     */
    public void setId_Utilisateur(final int id_Utilisateur) {
        this.id_Utilisateur = id_Utilisateur;
    }

    /**
     * @return the numero_Commande
     */
    public String getNumero_Commande() {
        return numero_Commande;
    }

    /**
     * @param numero_Commande the numero_Commande to set
     */
    public void setNumero_Commande(final String numero_Commande) {
        this.numero_Commande = numero_Commande;
    }

    /**
     * @return the date_Commande
     */
    public Date getDate_Commande() {
        return date_Commande;
    }

    /**
     * @param date_Commande the date_Commande to set
     */
    public void setDate_Commande(final Date date_Commande) {
        this.date_Commande = date_Commande;
    }

    /**
     * @return the montant_Avec_Remise
     */
    public double getMontant_Avec_Remise() {
        return montant_Avec_Remise;
    }

    /**
     * @param montant_Avec_Remise the montant_Avec_Remise to set
     */
    public void setMontant_Avec_Remise(final double montant_Avec_Remise) {
        this.montant_Avec_Remise = montant_Avec_Remise;
    }
}
