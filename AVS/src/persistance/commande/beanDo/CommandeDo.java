package persistance.commande.beanDo;

import java.util.Date;

/**
 * Représentation de la commande dans la base de donnée
 * 
 * @author Administrateur
 *
 */
public class CommandeDo {
    private int    idCommande;
    private int    idUtilisateur;
    private String numeroCommande;
    private Date   dateCommande;
    private double montantSansRemise;
    private double montantAvecRemise;

    public CommandeDo() {
        //empty constructeur
    }

    /**
     * @return the idCommande
     */
    public int getIdCommande() {
        return idCommande;
    }

    /**
     * @param idCommande the idCommande to set
     */
    public void setIdCommande(final int idCommande) {
        this.idCommande = idCommande;
    }

    /**
     * @return the idUtilisateur
     */
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    /**
     * @param idUtilisateur the idUtilisateur to set
     */
    public void setIdUtilisateur(final int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    /**
     * @return the numeroCommande
     */
    public String getNumeroCommande() {
        return numeroCommande;
    }

    /**
     * @param numeroCommande the numeroCommande to set
     */
    public void setNumeroCommande(final String numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    /**
     * @return the dateCommande
     */
    public Date getDateCommande() {
        return dateCommande;
    }

    /**
     * @param dateCommande the dateCommande to set
     */
    public void setDateCommande(final Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    /**
     * @return the montantSansRemise
     */
    public double getMontantSansRemise() {
        return montantSansRemise;
    }

    /**
     * @param montantSansRemise the montantSansRemise to set
     */
    public void setMontantSansRemise(final double montantSansRemise) {
        this.montantSansRemise = montantSansRemise;
    }

    /**
     * @return the montantAvecRemise
     */
    public double getMontantAvecRemise() {
        return montantAvecRemise;
    }

    /**
     * @param montantAvecRemise the montantAvecRemise to set
     */
    public void setMontantAvecRemise(final double montantAvecRemise) {
        this.montantAvecRemise = montantAvecRemise;
    }

}
