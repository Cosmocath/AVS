/**
 * 
 */
package persistance.droit.dao;

import java.util.List;
import java.util.Map;

/**
 * @author Administrateur
 *
 */
public interface IDroitAccesUrl {
    /**
     * @return
     */
    Map<String, List<String>> findAllDroits(); 
}
