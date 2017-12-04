package ch.uzh.ifi.seal.property.service;

import ch.uzh.ifi.seal.product.model.Product;
import ch.uzh.ifi.seal.property.model.Property;
import java.util.HashSet;
import java.util.Set;

public class PropertyImport {
    public Set<Property> getPropertiesForProduct(Product product) {
        //We need some basic properties for this product like color and the dimensions
        //The information comes from a datasource
        Set<Property> properties = new HashSet<>();
        PropertyDatasource datasource = new PropertyDatasource("https://api.properties.ch");
        properties.add(datasource.findColor(product));
        properties.addAll(datasource.findDimensions(product));
        return properties;
    }
}
