package service.image.impl;

import java.io.File;

import persistance.image.dao.IImageDao;
import service.image.IImageService;
import util.factory.Factory;

/**
 * Services de gestion des images
 * 
 * @author Rodolphe
 *
 */
public class ImageService implements IImageService {

    /**
     * image par d�faut en cas de probl�me de conversion de fichier
     */
    public static final String DEFAULT_IMAGE     = "C:\\AVS_Images\\AVS_Default.jpg";
    /**
     * r�pertoire images
     */
    public static final String REPERTOIRE_IMAGES = "C:\\AVS_Images\\AVS_Produits\\";

    /**
     * Constructeur
     */
    private ImageService() {
        // empty method
    }

    @Override
    public byte[] getImage(final String urlImage) {
        // obtention des images : l'image pass�e en param�tre, sinon l'image par d�faut, sinon null
        final IImageDao iImageDao = Factory.getInstance(IImageDao.class);
        final byte[] image = iImageDao.getImage(REPERTOIRE_IMAGES + urlImage);
        if (image == null) {
            return iImageDao.getImage(DEFAULT_IMAGE);
        }
        return image;
    }

    @Override
    public boolean uploadImage(final byte[] file, final String fileName) {
        final IImageDao iImageDao = Factory.getInstance(IImageDao.class);

        if (!("").equals(fileName)) {
            final File newFile = new File(ImageService.REPERTOIRE_IMAGES, fileName);
            if (!newFile.exists()) {
                return iImageDao.uploadImage(file, newFile);
            }
        }
        return false;
    }

}
