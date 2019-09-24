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
     * @return le File de l'image
     */
    byte[] getImage(final String urlImage);
}
