package persistance.droit.dao;

import java.util.List;
import persistance.droit.beanDo.DroitDo;

/**
 * Interface permattant de d�clarer une liste de tous les droits
 * 
 * @author Guy-J�el et Mireille
 *
 */
public interface IDroitDao {
    /**
     * @return une liste des droitDos
     */
    List<DroitDo> findAllDroits();
}
