package org.abhishek.kadaneAlgo;

public class MaxSubArraySum {

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int maxSum = nums[0];

        for(int i =1;i< nums.length ;i++) {
            maxSum = Math.max(maxSum+nums[i], nums[i]);
            res = Math.max(maxSum, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,-5,7,-1, 2, -10};
        System.out.println(maxSubArray(nums));
    }
}
