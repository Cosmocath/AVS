package presentation.commande.beanDto;

import java.io.Serializable;
import java.util.Map;

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
    private static final long                serialVersionUID = 542346324375306389L;

    private Integer                          idUtilisateur;
    private Integer                          idCommande;
    private String                           numeroCommande;
    private String                           date;
    private String                           montantAvecRemise;
    private String                           remise;
    private String                           montantSansRemise;
    private Map<CommandeProduitDto, Integer> mapProduitDto;
    private String                           adresseLivraison;
    private String                           adresseFacturation;

    /**
     * Builder pour le Dto
     * 
     * @param idUtilisateur
     * @param idCommande
     * @param numeroCommande
     * @param date
     * @param montantAvecRemise
     * @param remise
     * @param montantSansRemise
     * @param mapProduitDto
     * @return la commade Dto Initialisé
     */
    public static CommandeDto build(final Integer idUtilisateur, final Integer idCommande, final String numeroCommande, final String date, final String montantAvecRemise, final String remise,
                    final String montantSansRemise, final Map<CommandeProduitDto, Integer> mapProduitDto, final String adresseLivraison, final String adresseFacturation) {
        final CommandeDto commandeDto = new CommandeDto();
        commandeDto.setIdUtilisateur(idUtilisateur);
        commandeDto.setIdCommande(idCommande);
        commandeDto.setNumeroCommande(numeroCommande);
        commandeDto.setDate(date);
        commandeDto.setMontantAvecRemise(montantAvecRemise);
        commandeDto.setRemise(remise);
        commandeDto.setMontantSansRemise(montantSansRemise);
        commandeDto.setMapProduitDto(mapProduitDto);
        commandeDto.setAdresseLivraison(adresseLivraison);
        commandeDto.setAdresseFacturation(adresseFacturation);
        return commandeDto;
    }

    /**
     * La methode permet de retourner le build CommandeDto
     * 
     * @param idCommande
     * @param numeroCommande
     * @param date
     * @param montantAvecRemise
     * @param remise
     * @param montantSansRemise
     * @param mapProduitDto
     * @return la commande Dto Initialisé
     */
    public static CommandeDto build(final Integer idCommande, final String numeroCommande, final String date, final String montantAvecRemise, final String remise, final String montantSansRemise,
                    final Map<CommandeProduitDto, Integer> mapProduitDto, final String adresseLivraison, final String adresseFacturation) {
        return build(null, idCommande, numeroCommande, date, montantAvecRemise, remise, montantSansRemise, mapProduitDto, adresseLivraison, adresseFacturation);
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
     * @param date the date to set
     */
    public void setDate(final String date) {
        this.date = date;
    }

    /**
     * @return the montantAvecRemise
     */
    public String getMontantAvecRemise() {
        return montantAvecRemise;
    }

    /**
     * @param montantAvecRemise the montantAvecRemise to set
     */
    public void setMontantAvecRemise(final String montantAvecRemise) {
        this.montantAvecRemise = montantAvecRemise;
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
     * @return the montantSansRemise
     */
    public String getMontantSansRemise() {
        return montantSansRemise;
    }

    /**
     * @param montantSansRemise the montantSansRemise to set
     */
    public void setMontantSansRemise(final String montantSansRemise) {
        this.montantSansRemise = montantSansRemise;
    }

    /**
     * @return the mapProduitDto
     */
    public Map<CommandeProduitDto, Integer> getMapProduitDto() {
        return mapProduitDto;
    }

    /**
     * @param mapProduitDto the mapProduitDto to set
     */
    public void setMapProduitDto(final Map<CommandeProduitDto, Integer> mapProduitDto) {
        this.mapProduitDto = mapProduitDto;
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
