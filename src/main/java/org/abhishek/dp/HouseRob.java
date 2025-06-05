package org.abhishek.dp;

import java.util.Arrays;

public class HouseRob {

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);

        return robHelper(nums.length-1, nums, dp);
    }

    public static int robHelper(int i, int[] nums, int[] dp) {

        if(i==0) {
            return nums[0];
        }
        if(i==1) {
            return Math.max(nums[0], nums[1]);
        }
        if(dp[i]==-1) {
            dp[i] = Math.max(robHelper(i-1, nums, dp), robHelper(i-2, nums, dp) +nums[i]);
        }
        return dp[i];
    }

    public static void main(String[] args) {
        int[] nums = {1,3,7,3,5,8,2};
        System.out.println(rob(nums));
    }
}
