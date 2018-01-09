package ch.uzh.ifi.seal.product.controller;

import ch.uzh.ifi.seal.advertisement.service.YoutubeService;
import ch.uzh.ifi.seal.image.service.ProductImageService;
import ch.uzh.ifi.seal.marketing.service.MarketingInformationService;
import ch.uzh.ifi.seal.product.model.Product;
import ch.uzh.ifi.seal.property.service.PropertyImport;
import ch.uzh.ifi.seal.supplierdata.model.SupplierPurchaseData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductController {

    private final ProductImageService productImageService;

    private final PropertyImport propertyImport;

    private final MarketingInformationService marketingInformationService;

    private final YoutubeService youtubeService;

    /**
     * Purity: FieldModifier, Native   <br>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link MarketingInformationService#MarketingInformationService()} (origin: {@link java.security.AccessController#doPrivileged})      </li>
     * </ul>
     */
    public ProductController() {
        productImageService = new ProductImageService();
        propertyImport = new PropertyImport();
        marketingInformationService = new MarketingInformationService();
        youtubeService = new YoutubeService();
    }

    /**
     * Purity: FieldModifier, Native   <br>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link ProductImageService#uploadImagesFromDisk} (origin: {@link java.util.Collection#toArray})      </li>
     * <li>      {@link ArrayList#ArrayList()} (origin: {@link java.util.Collection#toArray})      </li>
     * <li>      {@link PropertyImport#getPropertiesForProduct} (origin: {@link java.lang.Float#floatToRawIntBits})      </li>
     * <li>      {@link MarketingInformationService#findMarketingInformationForProduct} (origin: {@link java.lang.Float#floatToRawIntBits})      </li>
     * </ul>
     */
    public Product createNewProduct(List<SupplierPurchaseData> purchasingData) {
        Product product = new Product();
        product.Name = purchasingData.get(0).ProductName;
        product.Brand = purchasingData.get(0).Brand;
        product.Ean = purchasingData.get(0).Ean;
        product.ManufacturerKey = purchasingData.get(0).ManufacturerKey;
        product.PurchasingInformation = purchasingData;
        //The product needs some good images. We have them stored on our disk so we upload them from there
        product.ProductImages = productImageService.uploadImagesFromDisk("./images/");
        //No product is complete without a nice video. We can import one directly from Youtube
        product.ProductVideos = new ArrayList<>(Collections.singletonList(youtubeService.downloadVideo(product)));
        //Some basic properties are needed every time a new product is created
        product.Properties = propertyImport.getPropertiesForProduct(product);
        //we finish it up with some marketing texts in different languages
        product.MarketingInformationSet = marketingInformationService.findMarketingInformationForProduct(product);
        return product;
    }
}
