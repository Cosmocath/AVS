package service.image;

/**
 * Service de gestion d'image
 * 
 * @author Rodolphe
 *
 */
public interface IImageService {
    /**
     * Obtention d'une image � partir de son url absolue
     * 
     * @param urlImage
     * @return un tableau d'octets
     */
    byte[] getImage(final String urlImage);
    
    /**
     * R�cup�re un tableau de byte et appel le dao pour �crire dans un repertoire
     * 
     * @param file : le fichier sous la forme bye
     * @return le chemin ou est stock� l'image
     */
    String uploadImage(final byte[] file, final String fileName);
}
