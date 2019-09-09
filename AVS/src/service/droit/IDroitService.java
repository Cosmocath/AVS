package service.droit;

import java.util.List;
import java.util.Map;

/**
 * Interface permettant de déclarer une méthode qui retourne tous les droits avec les droits
 * 
 * @author Guy-Jöel et Mireille
 *
 */
public interface IDroitService {
    /**
     * @return une map qui prend en clé une url, et en valeur une liste de profil qui a accès à l'url
     */
    Map<String, List<String>> findAllDroitsWithProfil();
    
    /**
     * permet de verifier si le profil a accès à l'url
     * 
     * @param profil à tester
     * @param l'url
     * @return true si Accès ok, sinon false
     */
    boolean isAcces(final String url, final String profil);
}
