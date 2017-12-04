package ch.uzh.ifi.seal.pricing.service;

public class RelativePricingService {
    public double getBrandFraction(String brand) {
        if (brand.equals("Apple")) {
            return 0.05;
        }

        if (brand.equals("Huawei")) {
            return 0.08;
        }

        return 0.1;
    }

    public double getCategoryFraction(String category) {
        if (category.equals("Mobile phone")) {
            return 0.01;
        }

        if (category.equals("Tablet")) {
            return 0.02;
        }

        return 0.08;
    }
}
