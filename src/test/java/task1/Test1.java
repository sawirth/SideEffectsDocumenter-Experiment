package task1;

import ch.uzh.ifi.seal.advertisement.controller.AdvertisementController;
import ch.uzh.ifi.seal.pricing.controller.PricingController;
import ch.uzh.ifi.seal.product.controller.ProductController;
import ch.uzh.ifi.seal.product.model.Product;
import org.junit.Test;

public class Test1 {
    @Test
    public void Task1() {
        //Sollte min. 5 Statements haben

        //Suchen nach passenden Lieferantendaten


        //Erfassen des Produktes (Infos, Texte (mit Übersetzungen), Bilder, Videos, Zubehör)
        ProductController productController = new ProductController();
        Product product = productController.createNewProduct();

        //Preis (Konkurrenten anschauen, Währung, Mwst, Marge)
        PricingController pricingController = new PricingController();
        pricingController.setBestPriceForProduct(product);

        //Werbung erstellen, kaufen, live schalten
        AdvertisementController advertisementController = new AdvertisementController();
        advertisementController.createTheUltimateAdvertisement(product);

        //Produkt für den Shop freischalten (Aktivieren, Cachen)
    }
}