package persistance.image.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

import persistance.image.dao.IImageDao;
import service.image.impl.ImageService;
import util.factory.Factory;

/**
 * @author Rodolphe
 *
 */
class ImageDaoTest {

    /**
     * Test method for {@link persistance.image.dao.impl.ImageDao#getImage(java.lang.String)}.
     */
    @Test
    void testGetImage() {
        final IImageDao iImageDao = Factory.getInstance(IImageDao.class);
        assertNotNull(iImageDao.getImage("C:\\AVS_Images\\AVS_Produits\\motocyclette.jpg"));
        assertNull(iImageDao.getImage("toto"));
    }

    /**
     * Test method for {@link persistance.image.dao.impl.ImageDao#uploadImage(java.lang.byte[], java.lang.String)}.
     */
    @Test
    void testUploadImage() {
        final IImageDao iImageDao = Factory.getInstance(IImageDao.class);
        assertTrue(iImageDao.uploadImage(iImageDao.getImage(new File("").getAbsolutePath() + "\\WebContent\\img\\logo_panier.png"), new File(ImageService.REPERTOIRE_IMAGES, "test.jpg")));
        assertNotNull(iImageDao.getImage("C:\\AVS_Images\\AVS_Produits\\test.jpg"));
    }
}
