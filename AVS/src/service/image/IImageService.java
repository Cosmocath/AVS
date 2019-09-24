package service.image;

/**
 * Service de gestion d'image
 * 
 * @author Rodolphe
 *
 */
public interface IImageService {
    /**
     * Obtention d'une image à partir de son url absolue
     * 
     * @param urlImage
     * @return un tableau d'octets
     */
    byte[] getImage(final String urlImage);
}
