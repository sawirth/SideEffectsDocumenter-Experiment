package ch.uzh.ifi.seal.customer.service;

import ch.uzh.ifi.seal.customer.model.Customer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CustomerService {

    /**
     * Purity: Stateless   <br>
     */
    public Set<Customer> loadCustomers() {
        return new HashSet<>(Arrays.asList(new Customer("Sepp Tr�tsch", "sepp@tr�tsch.ch", "Zurich"), new Customer("Max Mustermann", "max.mustermann@muster.ch", "Basel"), new Customer("Hans Wurst", "theWurster@gmx.ch", "Bern")));
    }
}
