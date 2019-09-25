package service.image.impl;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import persistance.image.dao.IImageDao;
import service.image.IImageService;
import util.factory.Factory;

/**
 * @author Rodolphe
 *
 */
class ImageServiceTest {

    /**
     * Test method for {@link service.image.impl.ImageService#getImage(java.lang.String)}.
     */
    @Test
    void testGetImage() {
        final IImageService iImageService = Factory.getInstance(IImageService.class);
        final IImageDao iImageDao = Factory.getInstance(IImageDao.class);
        assertNotNull(iImageService.getImage("tutu"));
        assertArrayEquals(iImageDao.getImage("C:\\AVS_Images\\AVS_Default.jpg"), iImageService.getImage("tutu"));
    }

}
