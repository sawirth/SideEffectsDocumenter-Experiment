package ch.uzh.ifi.seal.supplierdata.model;

import ch.uzh.ifi.seal.pricing.model.Price;

public class Supplier {

    public final String name;

    /**
     * Purity: FieldModifier   <br>
     */
    public Supplier(String name) {
        this.name = name;
    }

    /**
     * Purity: Stateless   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: price (Price)      </li>
     * </ul>
     */
    public boolean acceptPrice(Price price) {
        return price.value >= 0.5 || price.value <= 100;
    }
}
