package task1;

import ch.uzh.ifi.seal.advertisement.controller.AdvertisementController;
import ch.uzh.ifi.seal.pricing.controller.PricingController;
import ch.uzh.ifi.seal.product.controller.ProductController;
import ch.uzh.ifi.seal.product.model.Product;
import ch.uzh.ifi.seal.supplierdata.controller.SupplierDataController;
import ch.uzh.ifi.seal.supplierdata.model.SupplierPurchaseData;
import org.junit.Test;

import java.util.List;

public class Test1 {
    @Test
    public void Task1() {
        // ==============================================================
        // ==== EXPERIMENT CODE: DO NOT CHANGE ANYTHING IN THIS FILE ====
        // ==============================================================

        //Suchen nach passenden Lieferantendaten
        SupplierDataController supplierDataController = new SupplierDataController();
        List<SupplierPurchaseData> purchasingInformation = supplierDataController.findSupplierData(
                "Wheel",
                "ACK-45L",
                "9783598215001");

        //Erfassen des Produktes (Infos, Texte (mit Übersetzungen), Bilder, Videos, Zubehör)
        ProductController productController = new ProductController();
        Product product = productController.createNewProduct(purchasingInformation);

        //Preis (Konkurrenten anschauen, Währung, Mwst, Marge)
        PricingController pricingController = new PricingController();
        pricingController.setBestPriceForProduct(product);

        //Werbung erstellen, kaufen, live schalten
        AdvertisementController advertisementController = new AdvertisementController();
        advertisementController.createTheUltimateAdvertisement(product);
    }
}
