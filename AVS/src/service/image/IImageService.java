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
    
    /**
     * Récupère un tableau de byte et appel le dao pour écrire dans un repertoire
     * 
     * @param file : le fichier sous la forme bye
     * @return le chemin ou est stocké l'image
     */
    String uploadImage(final byte[] file, final String fileName);
}
