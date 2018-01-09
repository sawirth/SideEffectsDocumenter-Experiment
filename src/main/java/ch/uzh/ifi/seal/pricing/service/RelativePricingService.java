package ch.uzh.ifi.seal.pricing.service;

public class RelativePricingService {

    /**
     * Purity: Stateless   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: brand (String)      </li>
     * </ul>
     */
    public double getBrandFraction(String brand) {
        if (brand.equals("Apple")) {
            return 0.05;
        }
        if (brand.equals("Huawei")) {
            return 0.08;
        }
        return 0.1;
    }

    /**
     * Purity: Stateless   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: category (String)      </li>
     * </ul>
     */
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
