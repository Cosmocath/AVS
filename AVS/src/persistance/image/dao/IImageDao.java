package persistance.image.dao;

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
     * @return le chemin ou est stock� l'image
     */
    String uploadImage(final byte[] file, final String fileName);
}
