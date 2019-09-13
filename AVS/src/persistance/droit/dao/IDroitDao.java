package persistance.droit.dao;

import java.util.List;
import persistance.droit.beanDo.DroitDo;

/**
 * Interface permattant de déclarer une liste de tous les droits
 * 
 * @author Guy-Jöel et Mireille
 *
 */
public interface IDroitDao {
    /**
     * @return une liste des droitDos
     */
    List<DroitDo> findAllDroits();
}
