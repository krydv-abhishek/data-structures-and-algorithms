package org.abhishek.arrays;

public class BuySellStockI {

    public static int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if ((prices[i] - minPrice) > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {

        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(prices));

    }
}
