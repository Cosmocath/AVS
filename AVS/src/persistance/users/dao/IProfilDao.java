/**
 * 
 */
package persistance.users.dao;

import persistance.users.beanDo.ProfilDo;

/**
 * @author Administrator
 *
 */
public interface IProfilDao {

    /**
     * Permet de rechercher un profil selon son id
     * 
     * @param id
     * @return le profil recherché, null sinon
     */
    ProfilDo findProfilById(final Integer id);
}
