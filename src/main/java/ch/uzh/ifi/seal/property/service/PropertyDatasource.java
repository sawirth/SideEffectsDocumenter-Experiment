package ch.uzh.ifi.seal.property.service;

import ch.uzh.ifi.seal.product.model.Product;
import ch.uzh.ifi.seal.property.model.Property;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PropertyDatasource {

    public final String url;

    /**
     * Purity: FieldModifier   <br>
     */
    public PropertyDatasource(String url) {
        this.url = url;
    }

    /**
     * Purity: Stateless   <br>
     */
    public Property findColor(Product product) {
        return new Property("Color", "Red");
    }

    /**
     * Purity: Stateless   <br>
     */
    public Set<Property> findDimensions(Product product) {
        return new HashSet<>(Arrays.asList(new Property("Length", "30cm"), new Property("Width", "25cm"), new Property("Height", "33cm"), new Property("Weight", "1.2kg")));
    }
}
