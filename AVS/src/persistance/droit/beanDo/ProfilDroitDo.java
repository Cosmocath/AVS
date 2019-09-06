/**
 * 
 */
package persistance.droit.beanDo;

/**
 * @author Administrateur
 *
 */
public class ProfilDroitDo {
    private Integer  idProfilDroit;
    private ProfilDo profilDo;
    private DroitDo  droitDo;

    /**
     * 
     */
    public ProfilDroitDo() {
        // Empty method
    }

    /**
     * @return the idProfildroit
     */
    public Integer getIdProfilDroit() {
        return idProfilDroit;
    }

    /**
     * @param idProfildroit the idProfildroit to set
     */
    public void setIdProfilDroit(final Integer idProfilDroit) {
        this.idProfilDroit = idProfilDroit;
    }

    /**
     * @return the profilDo
     */
    public ProfilDo getProfilDo() {
        return profilDo;
    }

    /**
     * @param profilDo the profilDo to set
     */
    public void setProfilDo(final ProfilDo profilDo) {
        this.profilDo = profilDo;
    }

    /**
     * @return the droitDo
     */
    public DroitDo getDroitDo() {
        return droitDo;
    }

    /**
     * @param droitDo the droitDo to set
     */
    public void setDroitDo(final DroitDo droitDo) {
        this.droitDo = droitDo;
    }

}
