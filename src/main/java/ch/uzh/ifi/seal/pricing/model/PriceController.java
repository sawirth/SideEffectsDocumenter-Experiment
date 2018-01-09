package ch.uzh.ifi.seal.pricing.model;

import ch.uzh.ifi.seal.supplierdata.model.Supplier;
import ch.uzh.ifi.seal.supplierdata.service.SupplierService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PriceController {

    private List<Price> priceList;

    /**
     * Purity: FieldModifier   <br>
     */
    public PriceController(List<Price> priceList) {
        this.priceList = priceList;
    }

    /**
     * Purity: Native   <br>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link SupplierService#getSwissSuppliers} (origin: {@link java.lang.Float#floatToRawIntBits})      </li>
     * <li>      {@link HashSet#HashSet()} (origin: {@link java.lang.Float#floatToRawIntBits})      </li>
     * <li>      {@link Set#add}      </li>
     * <li>      {@link HashSet#HashSet()} (origin: {@link java.lang.Float#floatToRawIntBits})      </li>
     * <li>      {@link Set#removeAll}      </li>
     * </ul>
     */
    public void controlPrices() {
        SupplierService supplierService = new SupplierService();
        Set<Supplier> suppliers = supplierService.getSwissSuppliers();
        Set<Supplier> acceptedSuppliers = new HashSet<>();
        for (Supplier supplier : suppliers) {
            if (checkSupplier(supplier)) {
                acceptedSuppliers.add(supplier);
            }
        }
        Set<Supplier> notAcceptedSuppliers = new HashSet<>(suppliers);
        notAcceptedSuppliers.removeAll(acceptedSuppliers);
    }

    /**
     * Purity: Stateful   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: supplier (Supplier)      </li>
     * <li>      Field: this.priceList (java.util.List;)      </li>
     * </ul>
     */
    private boolean checkSupplier(Supplier supplier) {
        for (Price price : this.priceList) {
            boolean isAccepted = supplier.acceptPrice(price);
            if (!isAccepted) {
                return false;
            }
        }
        return true;
    }
}
