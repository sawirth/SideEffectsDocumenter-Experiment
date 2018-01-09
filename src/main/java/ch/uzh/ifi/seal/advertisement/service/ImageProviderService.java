package ch.uzh.ifi.seal.advertisement.service;

import ch.uzh.ifi.seal.advertisement.model.Image;
import ch.uzh.ifi.seal.product.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ImageProviderService {

    /**
     * Purity: Stateless   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: numberOfPhotos (int)      </li>
     * </ul>
     */
    public List<Image> findSuitableImages(Product product, String mood, int numberOfPhotos) {
        List<Image> images = new ArrayList<>();
        for (int i = 0; i < numberOfPhotos; i++) {
            images.add(findImage(mood));
        }
        return images;
    }

    /**
     * Purity: Stateless   <br>
     */
    private Image findImage(String searchText) {
        return new Image("www.google.ch/", "randomFileName");
    }
}
