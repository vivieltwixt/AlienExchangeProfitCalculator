package Models;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import static org.junit.Assert.*;

@RunWith(Parameterized. class)
public class DataSetTest {
    private String dataSet;
    private int expectedProfit;

    public DataSetTest(String dataSet, int expectedProfit) {
        this.dataSet = dataSet;
        this.expectedProfit = expectedProfit;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {smallDataSet, 1},
                {mediumDataSet, 1},
                {largeDataSet, 1},
        });
    }

    private static String smallDataSet = "2 2\n" +
            "2\n" +
            "2 0\n" +
            "0 5\n";

    private static String mediumDataSet = "2 2\n" +
            "2\n" +
            "2 0\n" +
            "0 5\n";

    private static String largeDataSet = "2 2\n" +
            "2\n" +
            "2 0\n" +
            "0 5\n";

    @Test
    /* Checks that determineBestProfitMargin function returns best profit for given data set*/
    public void determineBestProfitMarginTest() {
        DataSet data = new DataSet(new Scanner(dataSet));
        int result = data.determineBestProfitMargin();

        Assert.assertEquals(expectedProfit, result);
    }
}