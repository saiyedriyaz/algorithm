package net.demo.draft;

/**
 *
 */

/**
 * @author S425401
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

    public int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }

        int maxDiff = 0;
        int localMin = prices[0];
        int localMax = localMin;

        for (int price : prices) {
            if (price > localMax) {
                localMax = price;
                int localDiff = localMax - localMin;
                if (localDiff > maxDiff) {
                    maxDiff = localDiff;
                }
            } else if (price < localMin) {
                localMin = localMax = price;
            }
        }

        return maxDiff;
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
