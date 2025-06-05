package org.abhishek.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> hash = new HashMap<>();

        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int numberToFind = target - nums[i];
            Integer index = hash.get(numberToFind);
            if (index != null && index != i) {
                answer[0] = i;
                answer[1] = index;
                return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }
}
