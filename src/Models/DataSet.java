package Models;

import java.util.Scanner;

/*
*  Represents an input data set
* */
public class DataSet {
    private Scanner dataSetScanner;

    private int[] exchangeRates; // stores the exchange rate for each denomination in terms of the smallest denomination
    // Ex. [4,1] means 1 note of the denomination at the zero index is equivalent to 4 notes of the smallest denomination
    // and 1 note of the denomination at the 1 index is equivalent 1 note of the smallest denomination

    private int numPrices;

    private int lowestPrice;
    private int highestPrice;


    DataSet(Scanner sc) {
        dataSetScanner = sc;

        int numDenominations = sc.nextInt();
        numPrices = sc.nextInt();
        sc.nextLine(); // consume rest of line


        if( numDenominations > 7 | numDenominations < 2 | numPrices < 2 | numPrices > 10){
            throw new IllegalArgumentException ("Invalid parameter for number of denominations and/or number of prices.\n" );
              //      " numDenominations should be greater than 1 and less than 8\n" +
              //      " numPrices should be greater than 1 and less than 11\n"){};
        };


        exchangeRates = new int[numDenominations];

        lowestPrice = Integer.MAX_VALUE;
        highestPrice = Integer.MIN_VALUE;
    }

    /* Calculates the best possible profit for this data set*/
    public int determineBestProfitMargin() {
        calculateExchangeRates();

        for (int i = 0; i < numPrices; i++) {
            calculatePriceInSmallestDenomination();
        }

        return (highestPrice - lowestPrice);
    }

    private void calculateExchangeRates() {
        exchangeRates[exchangeRates.length - 1] = 1;

        String ratesString = dataSetScanner.nextLine();
        String[] ratesAsStrings = ratesString.split(" ");
        int[] ratesAsInts = stringArrayToIntArray(ratesAsStrings);

        for (int i = 0; i < ratesAsInts.length; i++) {
            exchangeRates[i] = productOfArrayValues(i, ratesAsInts); // Forms an array of exchange rates similar to
            // ratesAsInts (the list given by the output). However instead of listing exchange rates relative to the
            // next smallest denomination, exchangeRates list all rates in terms of their value in the smallest denomination.
            // Ex. [15,5,1] means 15 notes of the smallest denomination equals one note of the denomination at index 0,
            // 5 notes of the smallest denomination equals one note of the denomination at index 1.
        }
    }

    private void calculatePriceInSmallestDenomination() {
        String priceLine = dataSetScanner.nextLine();

        String[] priceAsStrings = priceLine.split(" ");
        int[] price = stringArrayToIntArray(priceAsStrings);

        int totalCost = 0;


        for (int j = 0; j < price.length; j++) {
            totalCost += price[j] * exchangeRates[j];
        }

        if (totalCost < lowestPrice)
            lowestPrice = totalCost;
        if (totalCost > highestPrice)
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
