package ch.uzh.ifi.seal.product.model;

import ch.uzh.ifi.seal.image.model.ProductImage;
import ch.uzh.ifi.seal.marketing.model.MarketingInformation;
import java.util.Set;

public class Product {
    public final String Name;
    public final String Brand;
    public final String ManufacturerKey;
    public final String Ean;
    public final Set<MarketingInformation> MarketingInformationSet;
    public final Set<ProductImage> ProductImages;

    public Product(String name,
                   String brand,
                   String manufacturerKey,
                   String ean,
                   Set<MarketingInformation> marketingInformationSet,
                   Set<ProductImage> productImages)
    {
        Name = name;
        Brand = brand;
        ManufacturerKey = manufacturerKey;
        Ean = ean;
        MarketingInformationSet = marketingInformationSet;
        ProductImages = productImages;
    }
}
