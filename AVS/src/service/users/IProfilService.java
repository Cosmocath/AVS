package service.users;

import presentation.users.beanDto.ProfilDto;

/**
 * Interface permettant de déclarer les méthodes du business service ProfilService
 * 
 * @author Administrateur
 *
 */
public interface IProfilService {
    /**
     * Permet de faire appel à la couche persistance afin de rechercher un profil en BDD à partir de son id
     * 
     * @param id
     * @return un ProfilDto du profil rechérché, null si non trouvé
     */
    ProfilDto findProfilById(final Integer id);
}
