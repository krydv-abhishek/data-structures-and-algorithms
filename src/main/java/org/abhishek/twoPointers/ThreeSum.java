package org.abhishek.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();
        nums = Arrays.stream(nums).sorted().toArray();
        for(int i =0; i< nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i+1, right = nums.length -1;
            while(left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if(sum == 0) {
                    answer.add(List.of(nums[left], nums[right], nums[i]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if(sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return answer;

    }

    public static void main(String[] args) {

        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));

    }
}
