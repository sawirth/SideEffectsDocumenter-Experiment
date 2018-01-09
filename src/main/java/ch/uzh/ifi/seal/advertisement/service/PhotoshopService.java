package ch.uzh.ifi.seal.advertisement.service;

import ch.uzh.ifi.seal.advertisement.model.Image;

public class PhotoshopService {

    /**
     * Purity: ArgumentModifier   <br>
     * 
     * Modifies the following arguments:
     * <ul>
     * <li>      image      </li>
     * </ul>
     */
    public void blurImage(Image image, int level) {
        image.BlurLevel = level;
    }

    /**
     * Purity: ArgumentModifier   <br>
     * 
     * Modifies the following arguments:
     * <ul>
     * <li>      image      </li>
     * </ul>
     */
    public void makeBlackAndWhite(Image image) {
        image.Saturation = 0;
    }

    /**
     * Purity: ArgumentModifier   <br>
     * 
     * Modifies the following arguments:
     * <ul>
     * <li>      image      </li>
     * </ul>
     */
    public void addInstagramFilter(Image image, String filter) {
        image.InstagramFilter = filter;
    }
}
