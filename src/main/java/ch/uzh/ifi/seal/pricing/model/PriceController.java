package ch.uzh.ifi.seal.pricing.model;

import ch.uzh.ifi.seal.supplierdata.model.Supplier;
import ch.uzh.ifi.seal.supplierdata.service.SupplierService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PriceController {
    private List<Price> priceList;

    public PriceController(List<Price> priceList) {
        this.priceList = priceList;
    }

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
