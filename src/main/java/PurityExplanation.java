import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class PurityExplanation {

    private int field;
    private static int staticField;

    /**
     *  Purity: Stateless
     */
    public int stateless(int a, int b) {
        return a + b;
    }

    /**
     *  Purity: OO Stateless   <br>
     *
     *  Return value depends on the following:
     *  <ul>
     *  <li>    Argument: a (int)     </li>
     *  </ul>
     */
    public int oo_stateless(int a) {
        return a + this.field;
    }

    /**
     * Purity: FieldModifier
     */
    public void fieldModifier(int a) {
        this.field = a;
    }

    /**
     * Purity: StaticModifier    <br>
     *
     * Modifies the following static fields:
     * <ul>
     * <li>    {@link PurityExplanation#staticField}     </li>
     * </ul>
     */
    public void staticModifier(int a) {
        staticField = a;
    }

    /**
     * Purity: ArgumentModifier     <br>
     *
     * Modifies the following arguments:
     * <ul>
     * <li>    rectangle     </li>
     * </ul>
     */
    public void argumentModifier(Rectangle rectangle) {
        rectangle.height = 100;
    }

    /**
     * Purity: Native    <br>
     *
     * The method calls native code:
     * <ul>
     * <li>    {@link PurityExplanation#nativeMethod()}    </li>
     * <li>    {@link FileWriter#write(String)} (Possible I/O) </li>
     * </ul>
     */
    public void nativeCall() {
        nativeMethod();

        try {
            FileWriter writer = new FileWriter("file.txt");
            writer.write("text in file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private native void nativeMethod();
}