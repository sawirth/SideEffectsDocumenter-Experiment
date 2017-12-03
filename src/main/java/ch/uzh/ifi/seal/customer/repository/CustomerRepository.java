package ch.uzh.ifi.seal.customer.repository;

import ch.uzh.ifi.seal.customer.model.Customer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CustomerRepository {
    public Set<Customer> GetAllCustomers() {
        return new HashSet<>(Arrays.asList(
           new Customer("")
        ));
    }
}
