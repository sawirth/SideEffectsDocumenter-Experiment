package ch.uzh.ifi.seal.property.service;

import ch.uzh.ifi.seal.product.model.Product;
import ch.uzh.ifi.seal.property.model.Property;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PropertyDatasource {
    public final String url;

    public PropertyDatasource(String url) {
        this.url = url;
    }

    public Property findColor(Product product) {
        return new Property("Color", "Red");
    }

    public Set<Property> findDimensions(Product product) {
        return new HashSet<>(Arrays.asList(
           new Property("Length", "30cm"),
           new Property("Width", "25cm"),
           new Property("Height", "33cm"),
           new Property("Weight", "1.2kg")
        ));
    }
}
