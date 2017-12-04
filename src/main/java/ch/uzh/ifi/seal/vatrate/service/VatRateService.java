package ch.uzh.ifi.seal.vatrate.service;

public class VatRateService {
    public double getVatRateFraction(String country) {
        if (country.equals("Germany")) {
            return 1.2;
        }

        return 1.08;
    }
}
