package ch.uzh.ifi.seal.image.service;

import ch.uzh.ifi.seal.image.model.ProductImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductImageService {
    public List<ProductImage> uploadImagesFromDisk(String folderPath) {
        return new ArrayList<>(Arrays.asList(
                new ProductImage("Front.jpeg", 500, 500, 755),
                new ProductImage("Packing.jpeg", 1000, 1000, 1200),
                new ProductImage("Usage.jpg", 888, 500, 862)
        ));
    }
}
