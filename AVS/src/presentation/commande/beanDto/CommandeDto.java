package presentation.commande.beanDto;

import java.io.Serializable;

/**
 * Représentation de l'écran CDE_00
 * 
 * @author Administrateur
 *
 */
public class CommandeDto implements Serializable {

    /**
     * generated UID
     */
    private static final long serialVersionUID = 542346324375306389L;

    private Integer           idUtilisateur;
    private Integer           idCommande;
    private String            numeroCommande;
    private String            date;
    private Double            montantAvecRemise;

    /**
     * Builder pour le Dto
     * 
     * @param idUtilisateur
     * @param idCommande
     * @param numeroCommande
     * @param date
     * @param montantAvecRemise
     * @return la commade Dto Initialisé
     */
    public static CommandeDto build(final Integer idUtilisateur, final Integer idCommande, final String numeroCommande, final String date, final Double montantAvecRemise) {
        final CommandeDto commandeDto = new CommandeDto();
        commandeDto.setIdUtilisateur(idUtilisateur);
        commandeDto.setIdCommande(idCommande);
        commandeDto.setNumeroCommande(numeroCommande);
        commandeDto.setDate(date);
        commandeDto.setMontantAvecRemise(montantAvecRemise);
        return commandeDto;
    }

    /**
     * @param idCommande
     * @param numeroCommande
     * @param date
     * @param montantAvecRemise
     * @return la commande Dto Initialisé
     */
    public static CommandeDto build(final Integer idCommande, final String numeroCommande, final String date, final Double montantAvecRemise) {
        return build(null, idCommande, numeroCommande, date, montantAvecRemise);
    }

    /**
     * @return the id_Utilisateur
     */
    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    /**
     * @param id_Utilisateur the id_Utilisateur to set
     */
    public void setIdUtilisateur(final Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    /**
     * @return the id_Commande
     */
    public Integer getIdCommande() {
        return idCommande;
    }

    /**
     * @param id_Commande the id_Commande to set
     */
    public void setIdCommande(final Integer idCommande) {
        this.idCommande = idCommande;
    }

    /**
     * @return the numero_Commande
     */
    public String getNumeroCommande() {
        return numeroCommande;
    }

    /**
     * @param numero_Commande the numero_Commande to set
     */
    public void setNumeroCommande(final String numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @return the montantAvecRemise
     */
    public Double getMontantAvecRemise() {
        return montantAvecRemise;
    }

    /**
     * @param montantAvecRemise the montantAvecRemise to set
     */
    public void setMontantAvecRemise(final Double montantAvecRemise) {
        this.montantAvecRemise = montantAvecRemise;
    }

    /**
     * @param date the date to set
     */
    public void setDate(final String date) {
        this.date = date;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
