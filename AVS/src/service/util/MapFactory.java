/**
 * 
 */
package service.util;
import java.util.List;
import java.util.Map;

import service.droit.IDroitAccesUrlService;
import util.Factory;

/**
 * @author Administrateur
 *
 */
public class MapFactory {
    private static Map<String, List<String>> map                   = null;
    private static IDroitAccesUrlService     iDroitAccesUrlService = Factory.getInstance(IDroitAccesUrlService.class);

    /**
     * @return
     */
    public static Map<String, List<String>> getMap() {
        if (map == null) {
            map = iDroitAccesUrlService.findAllDroits();
        }

        return map;
    }

}
