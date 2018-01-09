package ch.uzh.ifi.seal.advertisement.service;

import ch.uzh.ifi.seal.product.model.Product;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class WriterService {

    private final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final String lower = upper.toLowerCase();

    private final String alphabet = upper + lower;

    private Random random;

    /**
     * Purity: FieldModifier, Native   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: maxNumberOfWords (int)      </li>
     * </ul>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link Random#nextInt} (origin: {@link sun.misc.Unsafe#compareAndSwapLong})      </li>
     * <li>      {@link WriterService#generateWord} (origin: {@link sun.misc.Unsafe#compareAndSwapLong})      </li>
     * </ul>
     */
    public String writeAdvertisementText(Product product, int maxNumberOfWords) {
        StringBuilder text = new StringBuilder();
        random = ThreadLocalRandom.current();
        for (int i = 0; i < maxNumberOfWords; i++) {
            text.append(generateWord(random.nextInt(15)));
        }
        return text.toString();
    }

    /**
     * Purity: FieldModifier, Native   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: product (Product)      </li>
     * </ul>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link WriterService#writeAdvertisementText} (origin: {@link sun.misc.Unsafe#compareAndSwapLong})      </li>
     * </ul>
     */
    public String writeTagline(Product product) {
        return writeAdvertisementText(product, 10);
    }

    /**
     * Purity: FieldModifier, Native   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: product (Product)      </li>
     * </ul>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link WriterService#writeAdvertisementText} (origin: {@link sun.misc.Unsafe#compareAndSwapLong})      </li>
     * </ul>
     */
    public String writeDescription(Product product) {
        return writeAdvertisementText(product, 100);
    }

    /**
     * Purity: FieldModifier, Native   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: numberOfCharacters (int)      </li>
     * </ul>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link Random#nextInt} (origin: {@link sun.misc.Unsafe#compareAndSwapLong})      </li>
     * </ul>
     */
    private String generateWord(int numberOfCharacters) {
        random = ThreadLocalRandom.current();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < numberOfCharacters; i++) {
            int charPosition = random.nextInt(alphabet.length());
            word.append(alphabet.charAt(charPosition));
        }
        return word.toString();
    }
}
