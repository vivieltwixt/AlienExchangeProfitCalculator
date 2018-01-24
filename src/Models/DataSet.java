package Models;

import java.util.Scanner;

public class DataSet {
    private Scanner dataSetScanner;

    private int[] exchangeRates;
    private int numPrices;
    private int numDenominations;

    private int lowestPrice;
    private int highestPrice;


    DataSet(Scanner sc) {
        dataSetScanner = sc;

        numDenominations = sc.nextInt();
        numPrices = sc.nextInt();
        sc.nextLine(); // consume rest of line

        exchangeRates = new int[numDenominations];

        lowestPrice = Integer.MAX_VALUE;
        highestPrice = Integer.MIN_VALUE;
    }

    public int determineBestProfitMargin() {
        calculateExchangeRates();

        for (int i = 0; i < numPrices; i++) {
            calculatePriceInSmallestDenomination();
        }

        return highestPrice - lowestPrice;
    }

    private void calculateExchangeRates() {
        exchangeRates[exchangeRates.length - 1] = 1;

        String ratesString = dataSetScanner.nextLine();
        String[] ratesAsStrings = ratesString.split(" ");
        int[] ratesAsInts = stringArrayToIntArray(ratesAsStrings);

        for (int i = 0; i < ratesAsInts.length; i++) {
            exchangeRates[i] = productOfArrayValues(i, ratesAsInts);
        }

        //TODO: DEBUG
        for(int i=0; i< ratesAsInts.length; i++) {
            System.out.println(ratesAsInts[i]);
        }

       // System.out.println("numDenominations: " + numDenominations);
        System.out.println("numPrices: " + numPrices);

        for(int i=0; i<exchangeRates.length; i++){
            System.out.print(exchangeRates[i] + " ");
        }
        System.out.println();
    }

    private void calculatePriceInSmallestDenomination() {
        String priceLine = dataSetScanner.nextLine();

        String[] priceAsStrings = priceLine.split(" ");
        int[] price = stringArrayToIntArray(priceAsStrings);

        int totalCost = 0;

        System.out.println("Length of price " + price.length);
        System.out.println("Length of exchange rates " + exchangeRates.length);

        for (int j = 0; j < price.length; j++) {
            totalCost += price[j] * exchangeRates[j];
        }

        if (totalCost < lowestPrice)
            lowestPrice = totalCost;
        else if (totalCost > highestPrice)
            highestPrice = totalCost;
    }

    private int[] stringArrayToIntArray(String[] stringArray) {
        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }

        return intArray;
    }

    private int productOfArrayValues(int index, int[] ratesAsInts) {
        int product = 1;

        for (int i = index; i < ratesAsInts.length; i++) {
            product *= ratesAsInts[i];
        }

        return product;
    }

}
