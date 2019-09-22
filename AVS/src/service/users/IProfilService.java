package service.users;

import presentation.users.beanDto.ProfilDto;

/**
 * Interface permettant de d�clarer les m�thodes du business service ProfilService
 * 
 * @author Administrateur
 *
 */
public interface IProfilService {
    /**
     * Permet de faire appel � la couche persistance afin de rechercher un profil en BDD � partir de son id
     * 
     * @param id
     * @return un ProfilDto du profil rech�rch�, null si non trouv�
     */
    ProfilDto findProfilById(final Integer id);
}
