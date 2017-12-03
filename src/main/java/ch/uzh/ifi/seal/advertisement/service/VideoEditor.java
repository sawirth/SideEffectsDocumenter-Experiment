package ch.uzh.ifi.seal.advertisement.service;

import ch.uzh.ifi.seal.advertisement.model.Video;
import ch.uzh.ifi.seal.product.model.Product;

public class VideoEditor {
    public Video createAdvertisementVideo(Product product, int maxLengthInMinutes) {
        String title = "NEW ARRIVAL! " + product.Brand + " " + product.Name;
        return new Video(title, maxLengthInMinutes);
    }
}
