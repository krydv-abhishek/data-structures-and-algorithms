package org.abhishek.arrays;

public class BuySellStockII {

    public static int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }
        int minPrice = prices[0];
        int maxPrice = prices[0];
        int totalProfit = 0;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= minPrice) {
                minPrice = prices[i];
                maxPrice = prices[i];
            } else if(prices[i] <= maxPrice) {
                totalProfit = totalProfit + maxProfit;
                maxProfit = 0;
                minPrice = prices[i];
                maxPrice = prices[i];
            }

            else if ((prices[i] - minPrice) >= maxProfit) {
                maxProfit = prices[i] - minPrice;
                maxPrice = prices[i];
            }
            System.out.println(minPrice);
            System.out.println(maxPrice);
            System.out.println(totalProfit);
            System.out.println(maxProfit);
        }

        totalProfit = totalProfit + maxProfit;
        return totalProfit;
    }

    public static void main(String[] args) {

        int[] prices = {2, 1, 2, 0, 1};
        System.out.println(maxProfit(prices));

    }
}
