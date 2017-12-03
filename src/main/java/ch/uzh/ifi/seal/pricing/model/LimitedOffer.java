package ch.uzh.ifi.seal.pricing.model;

import ch.uzh.ifi.seal.product.model.Product;

public class LimitedOffer {
    public final Product product;
    public final int Quantity;
    public final double Price;

    public LimitedOffer(Product product, int quantity, double price) {
        this.product = product;
        Quantity = quantity;
        Price = price;
    }
}
