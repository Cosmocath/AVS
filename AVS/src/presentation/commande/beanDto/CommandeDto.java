/**
 * 
 */
package presentation.commande.beanDto;

import java.io.Serializable;

/**
 * @author Administrateur
 *
 */
public class CommandeDto implements Serializable {

    /**
     * generated UID
     */
    private static final long serialVersionUID = 542346324375306389L;

    private Integer           id_Utilisateur;
    private Integer           id_Commande;
    private String            numero_Commande;
    private String            date;
    private Integer           montantAvecRemise;

    /**
     * Builder pour le Dto
     * 
     * @param id_Utilisateur
     * @param id_Commande
     * @param numero_Commande
     * @param date
     * @param montantAvecRemise
     * @return la commade Dto Initialisé
     */
    public static CommandeDto build(final Integer id_Utilisateur, final Integer id_Commande, final String numero_Commande, final String date, final Integer montantAvecRemise) {
        final CommandeDto commandeDto = new CommandeDto();
        commandeDto.setId_Utilisateur(id_Utilisateur);
        commandeDto.setId_Commande(id_Commande);
        commandeDto.setNumero_Commande(numero_Commande);
        commandeDto.setDate(date);
        commandeDto.setMontantAvecRemise(montantAvecRemise);
        return commandeDto;
    }

    /**
     * @param id_Commande
     * @param numero_Commande
     * @param date
     * @param montantAvecRemise
     * @return la commande Dto Initialisé
     */
    public static CommandeDto build(final Integer id_Commande, final String numero_Commande, final String date, final Integer montantAvecRemise) {
        return build(null, id_Commande, numero_Commande, date, montantAvecRemise);
    }

    /**
     * @return the id_Utilisateur
     */
    public Integer getId_Utilisateur() {
        return id_Utilisateur;
    }

    /**
     * @param id_Utilisateur the id_Utilisateur to set
     */
    public void setId_Utilisateur(final Integer id_Utilisateur) {
        this.id_Utilisateur = id_Utilisateur;
    }

    /**
     * @return the id_Commande
     */
    public Integer getId_Commande() {
        return id_Commande;
    }

    /**
     * @param id_Commande the id_Commande to set
     */
    public void setId_Commande(final Integer id_Commande) {
        this.id_Commande = id_Commande;
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
    public void setNumero_Commande(String numero_Commande) {
        this.numero_Commande = numero_Commande;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(final String date) {
        this.date = date;
    }

    /**
     * @return the montantAvecRemise
     */
    public Integer getMontantAvecRemise() {
        return montantAvecRemise;
    }

    /**
     * @param montantAvecRemise the montantAvecRemise to set
     */
    public void setMontantAvecRemise(final Integer montantAvecRemise) {
        this.montantAvecRemise = montantAvecRemise;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
