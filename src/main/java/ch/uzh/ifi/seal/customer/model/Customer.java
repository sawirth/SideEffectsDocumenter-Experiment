package ch.uzh.ifi.seal.customer.model;

public class Customer {
    public final String Name;
    public final String Email;
    public final String City;

    public Customer(String name, String email, String city) {
        Name = name;
        Email = email;
        City = city;
    }
}
