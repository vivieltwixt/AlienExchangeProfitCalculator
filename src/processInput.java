import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class processInput {
 /*   private int numDataSets;
    private int numDenominations;
    private int numPrices;
    private int[] exchangeRates;

    private int lowestPrice = Integer.MAX_VALUE;
    private int highestPrice = Integer.MIN_VALUE;
    private int profit;

    private String filename = "input_1.txt";

    void initialProcessing() {
        File inputFile = new File("resources\\" + filename);
        Scanner sc = null;

        try {
            sc = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // TODO: Catch errors in formatting of file

        numDataSets = sc.nextInt();
        numDenominations = sc.nextInt();
        numPrices = sc.nextInt();
        sc.nextLine(); // consume rest of line

        exchangeRates = new int[numDenominations];
        exchangeRates[numDenominations - 1] = 1; //TODO: Commenting

        String ratesString = sc.nextLine();
        String[] ratesAsStrings = ratesString.split(" ");
        int[] ratesAsInts = stringArrayToIntArray(ratesAsStrings);

        for (int i = 0; i < ratesAsInts.length; i++) {
            exchangeRates[i] = productOfArrayValues(i, ratesAsInts);
        }

        //DEBUG
        for(int i=0; i< ratesAsInts.length; i++) {
            System.out.println(ratesAsInts[i]);
        }
        System.out.println("numDataSets: " + numDataSets);
        System.out.println("numDenominations: " + numDenominations);
        System.out.println("numPrices: " + numPrices);

        for(int i=0; i<exchangeRates.length; i++){
            System.out.print(exchangeRates[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < numPrices; i++) {
            String priceLine = sc.nextLine();
            String[] priceAsStrings = priceLine.split(" ");
            int[] price = stringArrayToIntArray(priceAsStrings);

            determineBestPricing(price);
        }

        System.out.println("The profit would be " + getBestProfitMargin());
    }

    private int productOfArrayValues(int index, int[] ratesAsInts) {
        int product = 1;

        for (int i = index; i < ratesAsInts.length; i++) {
            product *= ratesAsInts[i];
        }

        return product;
    }

    private int[] stringArrayToIntArray(String[] stringArray) {
        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }

        return intArray;
    }

    void determineBestPricings(int[] price) {
        int totalCost = 0;

        for (int i = 0; i < price.length; i++) {
            totalCost += price[i] * exchangeRates[i];
        }

        if (totalCost < lowestPrice)
            lowestPrice = totalCost;
        else if (totalCost > highestPrice)
            highestPrice = totalCost;
    }

    int getBestProfitMargin() {
        return highestPrice - lowestPrice;
    }
*/
}
