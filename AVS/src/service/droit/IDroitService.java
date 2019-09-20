package service.droit;

import java.util.List;
import java.util.Map;

/**
 * Interface permettant de d�clarer une m�thode qui retourne tous les droits avec les profils
 * 
 * @author Guy-J�el et Mireille
 *
 */
public interface IDroitService {
    /**
     * permet de recup�rer la liste des droits selon les profils
     * 
     * @return une map qui prend en cl� une url, et en valeur une liste de profil qui a acc�s � l'url
     */
    Map<String, List<String>> findAllDroitsWithProfil();

    /**
     * permet de verifier si le profil a acc�s � l'url, elle peut renvoyer une exception si le l'url est inconnue
     * 
     * @param profil � tester
     * @param l'url
     * @return true si Acc�s ok, sinon false
     */
    boolean isAcces(final String url, final String profil) throws IllegalArgumentException;
}
