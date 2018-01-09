package ch.uzh.ifi.seal.email.model;

public class Email {

    public final String Address;

    public final String Subject;

    public final String Content;

    /**
     * Purity: FieldModifier   <br>
     */
    public Email(String address, String subject, String content) {
        Address = address;
        Subject = subject;
        Content = content;
    }

    /**
     * Purity: Stateless   <br>
     */
    public boolean send() {
        return true;
    }
}
