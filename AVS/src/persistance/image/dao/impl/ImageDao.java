package persistance.image.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import persistance.image.dao.IImageDao;

/**
 * Gestion des images
 * 
 * @author Rodolphe
 *
 */
public class ImageDao implements IImageDao {

    /**
     * Constructeur
     */
    private ImageDao() {
        // empty method
    }

    /**
     * permet de test si le flux d'entrée contient un file et le transforme en Byte (flux d'octets)
     * 
     * @param inStream (conteneur de fichier)
     * @return un flux d'octet
     * @throws IOException
     */
    private byte[] readStream(final InputStream inStream) throws IOException {
        final ByteArrayOutputStream bops = new ByteArrayOutputStream();
        int data = -1;
        while ((data = inStream.read()) != -1) {
            bops.write(data);
        }
        return bops.toByteArray();
    }

    @Override
    public byte[] getImage(final String urlImage) {
        //stockage du chemin de l'image dans un file
        final File fileImage =  new File(urlImage);

        try (FileInputStream fisImage = new FileInputStream(fileImage)) {
            final byte[] byteImage = readStream(fisImage);
            return byteImage;
        } catch (final IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
