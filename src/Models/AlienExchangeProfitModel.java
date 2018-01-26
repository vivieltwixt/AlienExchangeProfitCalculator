package Models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class AlienExchangeProfitModel {
    private int numDataSets;
    private int[] profits;

    // TODO: Catch errors in formatting of file
    // TODO: Commenting

    public AlienExchangeProfitModel() {
        resetModel(); //initializing model
    }


    public void resetModel() {
        numDataSets = 0;
        profits = null;
    }

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
        } catch (java.util.NoSuchElementException e) {
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
