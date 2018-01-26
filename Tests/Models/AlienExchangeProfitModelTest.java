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


    private static String testStringLarge = "4\n" +
            "2 2\n" +
            "2\n" +
            "2 0\n" +
            "0 5\n" +
            "3 3\n" +
            "3 5\n" +
            "1 1 1\n" +
            "3 0 0\n" +
            "1 10 0\n" +
            "3 4\n" +
            "12 1\n" +
            "1 2 3\n" +
            "4 5 6\n" +
            "7 8 9\n" +
            "10 11 12\n" +
            "7 2\n" +
            "3 1 4 1 5 9\n" +
            "13 15 1 6 72 4\n" +
            "2 4 6 8 3 6";


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

    public AlienExchangeProfitModelTest(String inputFileAsString, int[] expectedProfits) {
        this.inputFileAsString = inputFileAsString;
        this.expectedProfits = expectedProfits;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"", null},
                {testStringSmall, new int[]{1,44}},
                {testStringLarge, new int[]{1,44,126,10017}},
                {testStringBadFormat, null}
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
    /* Checks that updateModelTest function obtains the correct profit list*/
    public void updateModelTest() throws IOException {
        File tmpFile = File.createTempFile("testInput", ".tmp");
        tmpFile.deleteOnExit();

        FileWriter writer = new FileWriter(tmpFile);
        writer.write(inputFileAsString);
        writer.close();

        model.updateModel(tmpFile);

        Assert.assertArrayEquals(expectedProfits, model.getProfits());
    }


}