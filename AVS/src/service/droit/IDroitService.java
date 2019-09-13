package service.droit;

import java.util.List;
import java.util.Map;

/**
 * Interface permettant de déclarer une méthode qui retourne tous les droits avec les profils
 * 
 * @author Guy-Jöel et Mireille
 *
 */
public interface IDroitService {
    /**
<<<<<<< HEAD
     * permet de recupérer la liste des droits selon les profils
=======
     * TODO XSI : compléter + formater
>>>>>>> a9f766e4777d9e948b391e77d52206312605927c
     * 
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
