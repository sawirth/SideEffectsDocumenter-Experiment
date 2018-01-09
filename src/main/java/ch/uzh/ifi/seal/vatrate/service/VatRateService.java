package ch.uzh.ifi.seal.vatrate.service;

public class VatRateService {

    /**
     * Purity: Stateless   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: country (String)      </li>
     * </ul>
     */
    public double getVatRateFraction(String country) {
        if (country.equals("Germany")) {
            return 1.2;
        }
        return 1.08;
    }
}
