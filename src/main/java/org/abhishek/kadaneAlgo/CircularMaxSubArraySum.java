package org.abhishek.kadaneAlgo;

public class CircularMaxSubArraySum {

    public static int maxSubarraySumCircular(int[] nums) {
        int res = nums[0];
        int maxSum = nums[0];

        int minSum = nums[0];
        int resMin = nums[0];

        int totalSum = nums[0];

        for(int i =1;i< nums.length ;i++) {
            totalSum += nums[i];

            maxSum = Math.max(maxSum+nums[i], nums[i]);
            res = Math.max(maxSum, res);

            minSum = Math.min(minSum+nums[i], nums[i]);
            resMin = Math.min(minSum, resMin);
        }

        if(totalSum-resMin == 0){
            return res;
        }

        return Math.max(res, totalSum - resMin);

    }

    public static void main(String[] args) {
        int[] nums = {1,2,-5,7,-1, 2, -100, 20};
        System.out.println(maxSubarraySumCircular(nums));
    }
}
