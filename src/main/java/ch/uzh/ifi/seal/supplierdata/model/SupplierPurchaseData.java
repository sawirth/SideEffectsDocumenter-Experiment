package ch.uzh.ifi.seal.supplierdata.model;

import ch.uzh.ifi.seal.currency.model.Currency;

public class SupplierPurchaseData {

    public final Supplier Supplier;
    public final String Ean;
    public final String ManufacturerKey;
    public final String ProductName;
    public final String Brand;
    public final int Stock;
    public final double priceExcl;
    public final Currency currency;

    /**
     * Purity: FieldModifier   <br>
     */
    public SupplierPurchaseData(ch.uzh.ifi.seal.supplierdata.model.Supplier supplier, String ean, String manufacturerKey, String productName, String brand, int stock, double priceExcl, Currency currency) {
        Supplier = supplier;
        Ean = ean;
        ManufacturerKey = manufacturerKey;
        ProductName = productName;
        Brand = brand;
        Stock = stock;
        this.priceExcl = priceExcl;
        this.currency = currency;
    }
}
