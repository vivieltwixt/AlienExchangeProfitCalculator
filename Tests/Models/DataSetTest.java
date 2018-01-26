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
                {smallDataSet, 44},
                {mediumDataSet, 44},
                {largeDataSet, 6326082},
        });
    }

    private static String smallDataSet = "2 2\n" +
            "3\n"  +
            "13 15\n" +
            "2 4";


    private static String mediumDataSet = "3 3\n" +
            "3 5\n" +
            "1 1 1\n" +
            "3 0 0\n" +
            "1 10 0\n";

    private static String largeDataSet = "7 10\n" +
            "12 1 4 5 13 27 \n" +
            "1 2 3 4 5 6 7\n" +
            "8 9 10 11 12 13 14\n" +
            "15 16 17 18 19 20 21\n" +
            "22 23 24 25 26 27 28\n" +
            "29 30 31 32 33 34 35\n" +
            "36 37 38 39 40 41 42\n" +
            "43 44 45 46 47 48 49\n" +
            "50 51 52 53 54 55 56\n" +
            "57 58 59 60 61 62 63\n" +
            "64 65 66 67 68 69 70\n";

    @Test
    /* Checks that determineBestProfitMargin function returns best profit for given data set*/
    public void determineBestProfitMarginTest() {
        DataSet data = new DataSet(new Scanner(dataSet));
        int result = data.determineBestProfitMargin();

        Assert.assertEquals(expectedProfit, result);
    }
}