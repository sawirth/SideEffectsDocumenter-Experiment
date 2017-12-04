package ch.uzh.ifi.seal.property.model;

public class Property {
    public final String Name;
    private String value;

    public Property(String name, String value) {
        Name = name;
        this.value = value;
    }

    public void changeValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
