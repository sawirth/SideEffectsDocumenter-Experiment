package ch.uzh.ifi.seal.advertisement.service;

import ch.uzh.ifi.seal.customer.model.Customer;
import ch.uzh.ifi.seal.customer.service.CustomerService;
import ch.uzh.ifi.seal.email.service.EmailClient;
import ch.uzh.ifi.seal.log.Logger;
import ch.uzh.ifi.seal.pricing.model.Price;
import ch.uzh.ifi.seal.product.model.Product;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpamService {

    private final EmailClient emailClient;

    private final Logger logger;

    /**
     * Purity: FieldModifier   <br>
     */
    public SpamService() {
        emailClient = new EmailClient();
        logger = new Logger();
    }

    /**
     * Purity: Stateless   <br>
     */
    public void sendSpam(Product product, Set<String> emailAddresses) {
        String subject = "YOU WON'T BELIEVE THIS DEAL!";
        String content = "New product arrived in our shop with an unbelievable price. Be quick to grab one for you!";
        int successful = 0;
        for (String email : emailAddresses) {
            boolean success = emailClient.sendMail(email, subject, content);
            if (success) {
                successful++;
            } else {
                logger.log("Email could not be sent");
            }
        }
    }

    /**
     * Purity: Native   <br>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link CustomerService#loadCustomers} (origin: {@link java.lang.Float#floatToRawIntBits})      </li>
     * <li>      {@link SpamService#getEmailAddresses} (origin: {@link java.lang.Float#floatToRawIntBits})      </li>
     * </ul>
     */
    public void sendSpam(List<Price> priceList) {
        CustomerService customerService = new CustomerService();
        Set<Customer> customers = customerService.loadCustomers();
        Set<String> emailAddresses = getEmailAddresses(customers);
        for (Price price : priceList) {
            for (String email : emailAddresses) {
                emailClient.sendMail(email, "SPAM", Integer.toString(price.value));
            }
        }
    }

    /**
     * Purity: Native   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: customers (Set<Customer>)      </li>
     * </ul>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link Set#add}      </li>
     * <li>      {@link HashSet#HashSet()} (origin: {@link java.lang.Float#floatToRawIntBits})      </li>
     * </ul>
     */
    private Set<String> getEmailAddresses(Set<Customer> customers) {
        Set<String> emailAddresses = new HashSet<>();
        for (Customer customer : customers) {
            emailAddresses.add(customer.Email);
        }
        return emailAddresses;
    }
}
