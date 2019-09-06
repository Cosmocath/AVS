/**
 * 
 */
package service.droit.impl;

import java.util.List;
import java.util.Map;

import persistance.droit.dao.IDroitAccesUrl;
import service.droit.IDroitAccesUrlService;
import util.Factory;

/**
 * @author Administrateur
 *
 */
public class DroitAccesUrlService implements IDroitAccesUrlService {
    final IDroitAccesUrl iDroitAccesUrl = Factory.getInstance(IDroitAccesUrl.class);

    private DroitAccesUrlService() {
        // Empty method
    }

    @Override
    public Map<String, List<String>> findAllDroits() {
        final Map<String, List<String>> map = iDroitAccesUrl.findAllDroits();
        return map;
    }

}
