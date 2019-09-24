package service.image.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import service.image.IImageService;
import util.factory.Factory;

class ImageServiceTest {

    @Test
    void testGetImage() {
        final IImageService iImageService = Factory.getInstance(IImageService.class);
        assertNotNull(iImageService);
        assertNotNull(iImageService.getImage("tutu"));
        assertNotNull(iImageService.getImage("C:\\AVS_Images\\AVS_Produits\\motocyclette.jpg"));
    }
}
