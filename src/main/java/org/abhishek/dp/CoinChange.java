package org.abhishek.dp;

public class CoinChange {


    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        return coinChangeHelper(coins, amount, dp);
    }


    public static int coinChangeHelper(int[] coins, int amount, int[] dp) {


        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        if (dp[amount - 1] == 0) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = coinChangeHelper(coins, amount - coin, dp);
                if (res >= 0 && res < min) {
                    min = 1 + res;

                }
            }
            dp[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount - 1];


    }

    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        System.out.println(coinChange(coins, 11));
    }

}
