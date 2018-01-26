package Models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
*  Processes the input files to calculate and store the best possible profit for each data set
* */
public class AlienExchangeProfitModel {
    private int numDataSets;
    private int[] profits; // stores the best possible profit for each data set Ex. [23, 17, 1] means 23 is the best
    // possible profit within the 1st data set, 17 for the second data set, etc.

    // TODO: Catch errors in formatting of file
    // TODO: Commenting

    public AlienExchangeProfitModel() {
        resetModel(); //initializing model
    }

    /* Set class variables to default values*/
    public void resetModel() {
        numDataSets = 0;
        profits = null;
    }

    /* Processes inputFile to calculate and store the best possible profit for each data set*/
    public void updateModel(File inputFile) {
        Scanner sc = null;
        try {
            sc = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            return; //TODO: alert for file not found
        }

        try {
            numDataSets = sc.nextInt();

            profits = new int[numDataSets];
            for (int i = 0; i < numDataSets; i++) {
                DataSet itemData = new DataSet(sc);
                profits[i] = itemData.determineBestProfitMargin();
            }
        } catch (java.util.NoSuchElementException | java.lang.IllegalArgumentException ex) {
            resetModel();
            //TODO: alert for incorrect format
            return;
        }
    }

    public int[] getProfits() {
        return profits;
    }

    public int getNumDataSets() {
        return numDataSets;
    }
}
