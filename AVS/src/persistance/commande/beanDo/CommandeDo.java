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
    private String nom;
    private String adresse_Livraison;
    private String adresse_Facturation;
    private String numero_Commande;
    private Date   date_Commande;
    private double montant_Sans_Remise;
    private double remise;

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
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(final String nom) {
        this.nom = nom;
    }

    /**
     * @return the adresse_Livraison
     */
    public String getAdresse_Livraison() {
        return adresse_Livraison;
    }

    /**
     * @param adresse_Livraison the adresse_Livraison to set
     */
    public void setAdresse_Livraison(final String adresse_Livraison) {
        this.adresse_Livraison = adresse_Livraison;
    }

    /**
     * @return the adresse_Facturation
     */
    public String getAdresse_Facturation() {
        return adresse_Facturation;
    }

    /**
     * @param adresse_Facturation the adresse_Facturation to set
     */
    public void setAdresse_Facturation(final String adresse_Facturation) {
        this.adresse_Facturation = adresse_Facturation;
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
     * @return the montant_Sans_Remise
     */
    public double getMontant_Sans_Remise() {
        return montant_Sans_Remise;
    }

    /**
     * @param montant_Sans_Remise the montant_Sans_Remise to set
     */
    public void setMontant_Sans_Remise(final double montant_Sans_Remise) {
        this.montant_Sans_Remise = montant_Sans_Remise;
    }

    /**
     * @return the remise
     */
    public double getRemise() {
        return remise;
    }

    /**
     * @param remise the remise to set
     */
    public void setRemise(final double remise) {
        this.remise = remise;
    }

}
