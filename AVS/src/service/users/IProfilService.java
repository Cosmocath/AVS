/**
 * 
 */
package service.users;

import presentation.users.beanDto.ProfilDto;

/**
 * @author Administrateur
 *
 */
public interface IProfilService {
    /**
     * Permet de faire appel � la couche persistance afin de rechercher un profil en BDD � partir de son id
     * 
     * @param id
     * @return
     */
    ProfilDto findProfilById(final Integer id);
}
