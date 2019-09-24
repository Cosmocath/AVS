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
     * @return le File de l'image
     */
    byte[] getImage(final String urlImage);
}
