package ch.uzh.ifi.seal.pricing.model;

import ch.uzh.ifi.seal.currency.model.Currency;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public abstract class SalesOffer {
    private double priceExcl;
    private Currency currency;
    private double vatRateFraction;
    private LocalDateTime deleteDate;

    public SalesOffer() {
        deleteDate = null;
    }

    public SalesOffer(double priceExcl, double vatRateFraction, Currency currency) {
        this.priceExcl = priceExcl;
        this.vatRateFraction = vatRateFraction;
        this.currency = currency;
        this.deleteDate = null;
    }

    public double getPriceIncl() {
        return this.priceExcl * vatRateFraction;
    }

    public double getPriceExcl() {
        return this.priceExcl;
    }

    public double getVatRateFraction() {
        return this.vatRateFraction;
    }

    public void deactivate() {
        this.deleteDate = LocalDateTime.now();
    }

    public void changePrice(double price, boolean isExcl) {
        if (isExcl) {
            this.priceExcl = price;
        } else {
            this.priceExcl = price / vatRateFraction;
        }
    }

    public boolean isValid() {
        return this.deleteDate == null;
    }

    public void activateSalesOffer() {
        this.deleteDate = null;
        try {
            PrintWriter writer = new PrintWriter("./resources/task1_db.txt");
            writer.print(this.priceExcl * vatRateFraction);
            writer.close();
        } catch (FileNotFoundException e) {
            //do nothing
        }
    }
}
