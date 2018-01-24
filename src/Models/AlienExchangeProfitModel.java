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
            e.printStackTrace();
        }

        numDataSets = sc.nextInt();

        profits = new int[numDataSets];
        for (int i = 0; i < numDataSets; i++) {
            System.out.println("Working on data set: " + i);
            DataSet itemData = new DataSet(sc);
            profits[i] = itemData.determineBestProfitMargin();
        }
    }

    public int[] getProfits() {
        return profits;
    }
}
