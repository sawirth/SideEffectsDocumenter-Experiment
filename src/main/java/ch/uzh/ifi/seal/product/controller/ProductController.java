package ch.uzh.ifi.seal.product.controller;

import ch.uzh.ifi.seal.image.model.ProductImage;
import ch.uzh.ifi.seal.image.service.ProductImageService;
import ch.uzh.ifi.seal.product.model.Product;
import ch.uzh.ifi.seal.property.service.PropertyImport;
import ch.uzh.ifi.seal.supplierdata.model.SupplierPurchaseData;
import java.util.List;

public class ProductController {
    private final ProductImageService productImageService;
    private final PropertyImport propertyImport;

    public ProductController() {
        productImageService = new ProductImageService();
        propertyImport = new PropertyImport();
    }

    public Product createNewProduct(List<SupplierPurchaseData> purchasingData) {
        //TODO eines der Hauptstatemente
        /*
            - Aus den SupplierData ein Produkt erstellen
            - allg. Infos eintragen
            - Marketing-Texte
            - Eigenschaften
            - Bilder
            - Zubehör
         */

        List<ProductImage> productImages = productImageService.uploadImagesFromDisk("./images/");



        return null;
    }
}
