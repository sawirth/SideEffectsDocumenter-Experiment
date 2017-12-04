package ch.uzh.ifi.seal.product.model;

import ch.uzh.ifi.seal.advertisement.model.Video;
import ch.uzh.ifi.seal.image.model.ProductImage;
import ch.uzh.ifi.seal.marketing.model.MarketingInformation;
import ch.uzh.ifi.seal.pricing.model.SalesOffer;
import ch.uzh.ifi.seal.property.model.Property;
import ch.uzh.ifi.seal.supplierdata.model.SupplierPurchaseData;
import java.util.List;
import java.util.Set;

public class Product {
    public String Name;
    public String Brand;
    public String ManufacturerKey;
    public String Ean;
    public Set<MarketingInformation> MarketingInformationSet;
    public List<ProductImage> ProductImages;
    public List<Video> ProductVideos;
    public List<SupplierPurchaseData> PurchasingInformation;
    public Set<Property> Properties;
    public SalesOffer SalesOffer;
    public String Category;
}
