package service.droit;

import java.util.List;
import java.util.Map;

/**
 * Interface permettant de d�clarer une m�thode qui retourne tous les droits avec les droits
 * 
 * @author Guy-J�el et Mireille
 *
 */
public interface IDroitService {
    /**
     * @return une map qui prend en cl� une url, et en valeur une liste de profil qui a acc�s � l'url
     */
    Map<String, List<String>> findAllDroitsWithProfil();
    
    /**
     * permet de verifier si le profil a acc�s � l'url
     * 
     * @param profil � tester
     * @param l'url
     * @return true si Acc�s ok, sinon false
     */
    boolean isAcces(final String url, final String profil);
}
