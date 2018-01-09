package ch.uzh.ifi.seal.advertisement.model;

import ch.uzh.ifi.seal.product.model.Product;
import java.util.List;

public class AdvertisementPage {

    public final Product Product;

    public final List<Image> Images;

    public final String AdvertisementText;

    private boolean isVisible;

    /**
     * Purity: FieldModifier   <br>
     */
    public AdvertisementPage(ch.uzh.ifi.seal.product.model.Product product, List<Image> images, String advertisementText) {
        Product = product;
        Images = images;
        AdvertisementText = advertisementText;
    }

    /**
     * Purity: Stateless   <br>
     */
    public void makeVisibleInShop() {
        this.isVisible = true;
    }

    /**
     * Purity: Stateless   <br>
     */
    public void hideInShop() {
        this.isVisible = false;
    }
}
