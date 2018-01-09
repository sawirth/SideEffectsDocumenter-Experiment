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

    /**
     * Purity: FieldModifier   <br>
     */
    public SalesOffer(double priceExcl, double vatRateFraction, Currency currency) {
        this.priceExcl = priceExcl;
        this.vatRateFraction = vatRateFraction;
        this.currency = currency;
        this.deleteDate = null;
    }

    /**
     * Purity: Stateful   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Field: this.priceExcl (double)      </li>
     * <li>      Field: this.vatRateFraction (double)      </li>
     * </ul>
     */
    public double getPriceIncl() {
        return this.priceExcl * vatRateFraction;
    }

    /**
     * Purity: Stateful   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Field: this.priceExcl (double)      </li>
     * </ul>
     */
    public double getPriceExcl() {
        return this.priceExcl;
    }

    /**
     * Purity: Stateful   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Field: this.vatRateFraction (double)      </li>
     * </ul>
     */
    public double getVatRateFraction() {
        return this.vatRateFraction;
    }

    /**
     * Purity: FieldModifier   <br>
     */
    public void deactivate() {
        this.deleteDate = LocalDateTime.now();
    }

    /**
     * Purity: FieldModifier   <br>
     */
    public void changePrice(double price, boolean isExcl) {
        if (isExcl) {
            this.priceExcl = price;
        } else {
            this.priceExcl = price / vatRateFraction;
        }
    }

    /**
     * Purity: Stateful   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Field of subclass: LimitedOffer.quantity (int)      </li>
     * </ul>
     */
    public boolean isValid() {
        return this.deleteDate == null;
    }

    /**
     * Purity: Native   <br>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link PrintWriter#print} (origin: {@link java.io.Writer#write} - Possible I/O)      </li>
     * <li>      {@link PrintWriter#PrintWriter()} (origin: {@link java.io.FileOutputStream#open} - Possible I/O)      </li>
     * <li>      {@link PrintWriter#close} (origin: {@link java.io.Writer#close} - Possible I/O)      </li>
     * </ul>
     */
    public void activateSalesOffer() {
        this.deleteDate = null;
        //comment the following try-catch out to solve it
        try {
            PrintWriter writer = new PrintWriter("./resources/task1_db.txt");
            writer.print(this.priceExcl * vatRateFraction);
            writer.close();
        } catch (FileNotFoundException e) {
        //do nothing
        }
    }
}
