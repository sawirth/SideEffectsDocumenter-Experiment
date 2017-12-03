package ctrl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Ctrl1 {

    //do not change this (could be hided if necessary)
    private static final double originalPrice = 100.0;
    private static final String filePath = "./resources/task1_db.txt";

    @Test
    public void ctrl1()
    {
        //This test has to be run before and after the experiment and should always succeed to complete the experiment
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            double price = Double.parseDouble(lines.get(0));
            double difference = Math.abs(price - originalPrice);
            if (difference > 0.001)
            {
                //let the test fail
                Assert.fail("Your test modified the Database which is not allowed.");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(filePath);
        writer.print("100");
        writer.close();
    }
}
