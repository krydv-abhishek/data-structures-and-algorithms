package org.abhishek.dp;

import java.util.Arrays;

public class LIS {

    public static int lengthOfLISItr(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int max = 1;
        for (int j : dp) {
            max = Math.max(max, j);
        }
        return max;

    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);

        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, lengthOfLISHelper(nums, dp, i));
        }
        return res;
    }

    public static int lengthOfLISHelper(int[] nums, int[] dp, int index) {

        if (index == 0) {
            return 1;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int mx = 1;

        for (int i = 0; i < index; i++) {
            if (nums[index] > nums[i]) {
                mx = Math.max(mx, lengthOfLISHelper(nums, dp, i) + 1);
            }
        }
        dp[index] = mx;

        return mx;


    }


    public static void main(String[] args) {

        int[] nums = {1, 12, 2, 6, 5, 10, 11, 8, 9};
        System.out.println(lengthOfLISItr(nums));
    }


}
