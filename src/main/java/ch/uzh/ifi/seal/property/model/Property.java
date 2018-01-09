package ch.uzh.ifi.seal.property.model;

public class Property {

    public final String Name;

    private String value;

    /**
     * Purity: FieldModifier   <br>
     */
    public Property(String name, String value) {
        Name = name;
        this.value = value;
    }

    /**
     * Purity: FieldModifier   <br>
     */
    public void changeValue(String value) {
        this.value = value;
    }

    /**
     * Purity: Stateful   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Field: this.value (java.lang.String;)      </li>
     * </ul>
     */
    public String getValue() {
        return this.value;
    }
}
