package persistance.image.dao;

import java.io.File;

/**
 * Gestion des images
 * 
 * @author Rodolphe
 *
 */
public interface IImageDao {

    /**
     * R�cup�re une image stock�e sur disque en chemin absolu
     * 
     * @param urlImage : le chemin absolu sur disque
     * @return le tableau d'octets de l'image
     */
    byte[] getImage(final String urlImage);

    /**
     * R�cup�re un tableau de byte et �crit le fichier dans un r�pertoire
     * 
     * @param file : le fichier sous la forme bye
     * @return true si l'upload � r�ussi, false sinon
     */
    boolean uploadImage(final byte[] file, final File newFile);
}
