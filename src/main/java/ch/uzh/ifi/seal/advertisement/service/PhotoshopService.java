package ch.uzh.ifi.seal.advertisement.service;

import ch.uzh.ifi.seal.advertisement.model.Image;

public class PhotoshopService {
    public void blurImage(Image image, int level) {
        image.BlurLevel = level;
    }

    public void makeBlackAndWhite(Image image) {
        image.Saturation = 0;
    }

    public void addInstagramFilter(Image image, String filter) {
        image.InstagramFilter = filter;
    }
}
