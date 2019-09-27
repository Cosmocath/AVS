package persistance.commande.beanDo;

import java.util.Date;
import java.util.Set;

/**
 * Représentation de la commande dans la base de donnée
 * 
 * @author Administrateur / Valentin
 *
 */
public class CommandeDo {
    private int                    idCommande;
    private int                    idUtilisateur;
    private String                 nom;
    private String                 numeroCommande;
    private Date                   dateCommande;
    private double                 montantSansRemise;
    private double                 remise;
    private String                 adresseLivraison;
    private String                 adresseFacturation;
    private Set<CommandeProduitDo> commandeProduitSet;

    /**
     * Constructeur
     * 
     */
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

    /**
     * @return the commandeProduitSet
     */
    public Set<CommandeProduitDo> getCommandeProduitSet() {
        return commandeProduitSet;
    }

    /**
     * @param commandeProduitSet the commandeProduitSet to set
     */
    public void setCommandeProduitSet(final Set<CommandeProduitDo> commandeProduitSet) {
        this.commandeProduitSet = commandeProduitSet;
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

}
