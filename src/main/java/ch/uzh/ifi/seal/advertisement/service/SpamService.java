package ch.uzh.ifi.seal.advertisement.service;

import ch.uzh.ifi.seal.email.service.EmailClient;
import ch.uzh.ifi.seal.log.Logger;
import ch.uzh.ifi.seal.product.model.Product;

import java.util.Set;

public class SpamService {
    private final EmailClient emailClient;
    private final Logger logger;

    public SpamService() {
        emailClient = new EmailClient();
        logger = new Logger();
    }

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
}
