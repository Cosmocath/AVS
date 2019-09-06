/**
 * 
 */
package persistance.droit.beanDo;

import java.util.Set;

/**
 * @author Administrateur
 *
 */
public class DroitDo {
    private Integer  idDroit;
    private String   url;
    private String   description;
    private Set<ProfilDroitDo> setProfilDroits;

    /**
     * 
     */
    public DroitDo() {
        // Empty method
    }

    /**
     * @return the idDroit
     */
    public Integer getIdDroit() {
        return idDroit;
    }

    /**
     * @param idDroit the idDroit to set
     */
    public void setIdDroit(final Integer idDroit) {
        this.idDroit = idDroit;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(final String url) {
        this.url = url;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @return the listeProfilDroits
     */
    public Set<ProfilDroitDo> getSetProfilDroits() {
        return setProfilDroits;
    }

    /**
     * @param listeProfilDroits the listeProfilDroits to set
     */
    public void setSetProfilDroits(final Set<ProfilDroitDo> setProfilDroits) {
        this.setProfilDroits = setProfilDroits;
    }

}
