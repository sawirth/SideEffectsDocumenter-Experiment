package ch.uzh.ifi.seal.customer.service;

import ch.uzh.ifi.seal.customer.model.Customer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CustomerService {

    /**
     * Purity: Native   <br>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link HashSet#HashSet()} (origin: {@link java.lang.Float#floatToRawIntBits})      </li>
     * </ul>
     */
    public Set<Customer> loadCustomers() {
        return new HashSet<>(Arrays.asList(new Customer("Sepp Trütsch", "sepp@trütsch.ch", "Zurich"), new Customer("Max Mustermann", "max.mustermann@muster.ch", "Basel"), new Customer("Hans Wurst", "theWurster@gmx.ch", "Bern")));
    }
}
