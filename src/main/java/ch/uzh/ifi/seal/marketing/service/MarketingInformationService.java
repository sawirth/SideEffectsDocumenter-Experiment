package ch.uzh.ifi.seal.marketing.service;

import ch.uzh.ifi.seal.advertisement.service.WriterService;
import ch.uzh.ifi.seal.marketing.model.MarketingInformation;
import ch.uzh.ifi.seal.product.model.Product;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MarketingInformationService {
    private final WriterService writerService;

    public MarketingInformationService() {
        writerService = new WriterService();
    }

    public Set<MarketingInformation> findMarketingInformationForProduct(Product product) {
        return new HashSet<>(Arrays.asList(
                new MarketingInformation(
                    "German",
                    writerService.writeDescription(product),
                    writerService.writeTagline(product)),
                new MarketingInformation(
                    "English",
                    writerService.writeDescription(product),
                    writerService.writeTagline(product)
                )));
    }
}
