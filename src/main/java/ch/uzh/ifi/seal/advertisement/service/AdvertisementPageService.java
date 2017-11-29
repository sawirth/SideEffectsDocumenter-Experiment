package ch.uzh.ifi.seal.advertisement.service;

import ch.uzh.ifi.seal.advertisement.model.AdvertisementPage;
import ch.uzh.ifi.seal.advertisement.model.Image;
import ch.uzh.ifi.seal.product.model.Product;
import java.util.List;

public class AdvertisementPageService {
    private final ImageProviderService imageProviderService;
    private final PhotoshopService photoshopService;
    private final WriterService writerService;

    public AdvertisementPageService() {
        imageProviderService = new ImageProviderService();
        photoshopService = new PhotoshopService();
        writerService = new WriterService();
    }

    public AdvertisementPage createNewAdvertisementPage(Product product) {
        //For our advertisement page we need some cool photos so we download some from our image provider
        List<Image> images = imageProviderService.findSuitableImages(product, "action", 3);

        //We need to apply some photoshop skills to make them look cooler
        photoshopService.addInstagramFilter(images.get(0), "Juno");
        photoshopService.blurImage(images.get(1), 5);
        photoshopService.makeBlackAndWhite(images.get(2));

        //The page needs a nice text to advertise the product. We ask our writer to write one for us
        String text = writerService.writeAdvertisementText(product, 500);

        return new AdvertisementPage(product, images, text);
    }
}
