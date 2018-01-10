package ch.uzh.ifi.seal.supplierdata.model;

import ch.uzh.ifi.seal.currency.model.Currency;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataSource {

    private final Supplier supplier;

    private boolean isConnected;

    /**
     * Purity: FieldModifier   <br>
     */
    public DataSource(Supplier supplier) {
        this.supplier = supplier;
    }

    /**
     * Purity: Stateless   <br>
     */
    public void connect() {
        this.isConnected = true;
    }

    /**
     * Purity: Stateless   <br>
     */
    public List<SupplierPurchaseData> download() {
        return new ArrayList<>(Arrays.asList(new SupplierPurchaseData(supplier, "9783598215001", "ACK-45L", "Wheel", "Buggli", 25, 25.95, Currency.CHF), new SupplierPurchaseData(supplier, "9783598215063", "BUT-11", "Sandwich", "Tutru", 99, 55.54, Currency.CHF)));
    }
}
