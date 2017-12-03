package ch.uzh.ifi.seal.email.service;

import ch.uzh.ifi.seal.email.model.Email;

public class EmailClient {
    public boolean sendMail(String emailAddress, String subject, String content) {
        Email email = new Email(emailAddress, subject, content);
        boolean success = email.send();
        if (success) {
            return success;
        } else {
            return tryResend(email);
        }
    }

    private boolean tryResend(Email email) {
        return email.send();
    }
}
