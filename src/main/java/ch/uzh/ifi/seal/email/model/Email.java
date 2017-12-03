package ch.uzh.ifi.seal.email.model;

public class Email {
    public final String Address;
    public final String Subject;
    public final String Content;

    public Email(String address, String subject, String content) {
        Address = address;
        Subject = subject;
        Content = content;
    }

    public boolean send() {
        return true;
    }
}
