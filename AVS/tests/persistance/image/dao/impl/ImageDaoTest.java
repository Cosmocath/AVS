package persistance.image.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import persistance.image.dao.IImageDao;
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
        //        assertNotNull(iImageDao.uploadImage(iImageDao.getImage("C:\\IMG\\téléchargement.jpg"), "téléchargement.jpg"));
    }
}
