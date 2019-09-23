/**
 * 
 */
package service.cgu.impl;

import persistance.cgu.dao.ICGUDao;

/**
 * implémentation de ICGUService
 * 
 * @author Administrateur
 *
 */
public class CGUService implements ICGUService {

    /**
     * constructeur
     */
    private CGUService() {
        //empty constructor
    }

    @Override
    public String afficherCGU() {
        final ICGUDao iCGUDao = util.Factory.getInstance(ICGUDao.class);
        return iCGUDao.lireCGUDao();
    }

}
