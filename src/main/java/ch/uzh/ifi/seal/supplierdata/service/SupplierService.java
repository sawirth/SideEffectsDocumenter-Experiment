package ch.uzh.ifi.seal.supplierdata.service;

import ch.uzh.ifi.seal.supplierdata.model.Supplier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SupplierService {

    /**
     * Purity: Stateless   <br>
     */
    public Set<Supplier> getSwissSuppliers() {
        return new HashSet<>(Arrays.asList(new Supplier("Tech 24"), new Supplier("BGS GmbH"), new Supplier("Onlineboss")));
    }
}
