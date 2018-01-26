package Models;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class AlienExchangeProfitModelTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    private AlienExchangeProfitModel model = new AlienExchangeProfitModel();
    private String inputFileAsString;
    private int[] expectedProfits;
    private int expectedNumDataSets;

    private static String testStringSmall = "2\n" +
            "2 2\n" +
            "2\n" +
            "2 0\n" +
            "0 5\n" +
            "3 3\n" +
            "3 5\n" +
            "1 1 1\n" +
            "3 0 0\n" +
            "1 10 0";

    private static String testStringMedium = "2\n" + //TODO
            "2 2\n" +
            "2\n" +
            "2 0\n" +
            "0 5\n" +
            "3 3\n" +
            "3 5\n" +
            "1 1 1\n" +
            "3 0 0\n" +
            "1 10 0";

    private static String testStringLarge = "2\n" + //TODO
            "2 2\n" +
            "2\n" +
            "2 0\n" +
            "0 5\n" +
            "3 3\n" +
            "3 5\n" +
            "1 1 1\n" +
            "3 0 0\n" +
            "1 10 0";

    private static String testStringBadFormat = "2\n" +
            "2 2\n" +
            "2\n" +
            //"2 0\n" +
            "0 5\n" +
            "3 3\n" +
            "3 5\n" +
            "1 1 1\n" +
            "3 0 0\n" +
            "1 10 0";

    public AlienExchangeProfitModelTest(String inputFileAsString, int[] expectedProfits, int expectedNumDataSets) {
        this.inputFileAsString = inputFileAsString;
        this.expectedProfits = expectedProfits;
        this.expectedNumDataSets = expectedNumDataSets;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
              //  {null, null, 0},
                {"", null, 0},
                {testStringSmall, new int[]{1,44}, 2},
                {testStringMedium, new int[]{1,44}, 2}, //TODO
                {testStringLarge, new int[]{1,44}, 2}, //TODO
                {testStringBadFormat, null, 0}
        });
    }

    @Test
    /* Checks that resetModel function sets AlienExchangeProfitModel to default values*/
    public void resetModelTest() {
        model.resetModel();

        Assert.assertEquals(0, model.getNumDataSets());
        Assert.assertNull(model.getProfits());
    }

    @Test
    /* Checks that updateModelTest function obtains the correct profit list and num of data set values*/
    public void updateModelTest() throws IOException {
        File tmpFile = File.createTempFile("testInput", ".tmp");
        tmpFile.deleteOnExit();

        FileWriter writer = new FileWriter(tmpFile);
        writer.write(inputFileAsString);
        writer.close();

        model.updateModel(tmpFile);

        Assert.assertEquals(expectedNumDataSets, model.getNumDataSets());
        Assert.assertArrayEquals(expectedProfits, model.getProfits());
    }


}