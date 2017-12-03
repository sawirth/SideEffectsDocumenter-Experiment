package ch.uzh.ifi.seal.product.model;

import ch.uzh.ifi.seal.image.model.ProductImage;
import ch.uzh.ifi.seal.marketing.model.MarketingInformation;
import ch.uzh.ifi.seal.supplierdata.model.SupplierPurchaseData;

import java.util.Set;

public class Product {
    public String Name;
    public String Brand;
    public String ManufacturerKey;
    public String Ean;
    public Set<MarketingInformation> MarketingInformationSet;
    public Set<ProductImage> ProductImages;
    public Set<SupplierPurchaseData> PurchasingInformation;

    public Product(String name,
                   String brand,
                   String manufacturerKey,
                   String ean,
                   Set<MarketingInformation> marketingInformationSet,
                   Set<ProductImage> productImages,
                   Set<SupplierPurchaseData> purchasingInformation)
    {
        Name = name;
        Brand = brand;
        ManufacturerKey = manufacturerKey;
        Ean = ean;
        MarketingInformationSet = marketingInformationSet;
        ProductImages = productImages;
        PurchasingInformation = purchasingInformation;
    }
}
