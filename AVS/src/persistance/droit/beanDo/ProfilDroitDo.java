package persistance.droit.beanDo;

import persistance.users.beanDo.ProfilDo;

/**
 * Repr�sentation du ProfilDroitDo en BD
 * 
 * @author Guy-J�el et Mireille
 *
 */
public class ProfilDroitDo {
    private Integer  idProfilDroit;
    private ProfilDo profilDo;
    private DroitDo  droitDo;

    /**
     * Constructeur sans param�tre
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
