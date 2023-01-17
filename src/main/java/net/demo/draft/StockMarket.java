package net.demo.draft;

/**
 *
 */

/**
 *
 */
public class StockMarket {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StockMarket obj = new StockMarket();
        int[] data = new int[]{10, 7, 17, 16, 15};
        int profit1 = obj.maxProfit(data);
        int profit2 = obj.maximumGain(data);
        System.err.println("profit1=" + profit1);
        System.err.println("profit2=" + profit2);
    }

    public int maxProfit(int[] stockPrices) {
        if (stockPrices.length < 1) {
            return 0;
        }

        int maxBenefit = 0, minPrice = stockPrices[0];
        int localMax = minPrice;

        for (int currentPrice : stockPrices) {
            if (currentPrice > localMax) {
                localMax = currentPrice;
                int localDiff = localMax - minPrice;
                if (localDiff > maxBenefit) {
                    maxBenefit = localDiff;
                }
            } else if (currentPrice < minPrice) {
                minPrice = localMax = currentPrice;
            }
        }

        return maxBenefit;
    }

    // submitted solution
    private int maximumGain(int[] allPricess) {
        int maxDiff = 0;
        if (allPricess.length > 0) {
            int min = allPricess[0];
            int max = min;

            for (int price : allPricess) {
                if (price > max) {
                    max = price;
                    int diff = max - min;
                    if (diff > maxDiff) {
                        maxDiff = diff;
                    }
                } else if (price < min) {
                    min = max = price;
                }
            }
        }
        return maxDiff;
    }

}
