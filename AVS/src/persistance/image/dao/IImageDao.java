package persistance.image.dao;

/**
 * Gestion des images
 * 
 * @author Rodolphe
 *
 */
public interface IImageDao {

    /**
     * Récupère une image stockée sur disque en chemin absolu
     * 
     * @param urlImage : le chemin absolu sur disque
     * @return le tableau d'octets de l'image
     */
    byte[] getImage(final String urlImage);

    /**
     * Récupère un tableau de byte et écrit le fichier dans un répertoire
     * 
     * @param file : le fichier sous la forme bye
     * @return le chemin ou est stocké l'image
     */
    String uploadImage(final byte[] file, final String fileName);
}
