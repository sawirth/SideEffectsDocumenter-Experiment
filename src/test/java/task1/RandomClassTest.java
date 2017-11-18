package task1;

import org.junit.Assert;
import org.junit.Test;

public class RandomClassTest {
    @Test
    public void testMethodToTest() throws Exception {
        int oldValue = Parameters.staticField;
        RandomClass randomClass = new RandomClass();
        randomClass.methodToTest();
        //Assert.assertEquals(oldValue, Parameters.staticField);
    }
}
