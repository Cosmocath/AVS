/**
 * 
 */
package service.users;

import util.TypeDeProfil;

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
    TypeDeProfil findProfilById(final Integer id);
}
