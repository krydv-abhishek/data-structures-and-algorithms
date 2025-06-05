package org.abhishek.twoPointers;

import java.util.Arrays;

/* 

https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.


Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

*/

public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {

        int[] ans = new int[2];

        int left = 0, right = numbers.length -1;

        while(left < right) {
            int sum = numbers[left] + numbers[right]; 
            if(sum == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                return ans;
            } else if(sum > target) {
                right--;
            } else if(sum < target) {
                left++;
            }     
        }
        return ans;        
    }

    public static void main(String[] args) {
        
        int[] nums = {0, 2, 5, 9, 11, 13, 13, 15, 17};
        System.out.println(Arrays.toString(twoSum(nums, 18)));

        int[] nums1 = {-1, 0};
        System.out.println(Arrays.toString(twoSum(nums1, -1)));

    }


}
