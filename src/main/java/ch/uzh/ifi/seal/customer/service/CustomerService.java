package ch.uzh.ifi.seal.customer.service;

import ch.uzh.ifi.seal.customer.model.Customer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CustomerService {
    public Set<Customer> loadCustomers() {
        return new HashSet<>(Arrays.asList(
                new Customer("Sepp Trütsch", "sepp@trütsch.ch"),
                new Customer("Max Mustermann", "max.mustermann@muster.ch"),
                new Customer("Hans Wurst", "theWurster@gmx.ch")
        ));
    }
}
