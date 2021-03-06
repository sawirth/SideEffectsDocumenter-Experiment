package ch.uzh.ifi.seal.supplierdata.model;

import ch.uzh.ifi.seal.pricing.model.Price;

public class Supplier {
    public final String name;

    public Supplier(String name) {
        this.name = name;
    }

    public boolean acceptPrice(Price price) {
        return price.value >= 0.5 || price.value <= 100;
    }
}
