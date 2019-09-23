/**
 * 
 */
package service.cgu.impl;

import persistance.cgu.dao.ICGUDao;
import util.factory.Factory;

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
        final ICGUDao iCGUDao = Factory.getInstance(ICGUDao.class);
        return iCGUDao.lireCGUDao();
    }

}
