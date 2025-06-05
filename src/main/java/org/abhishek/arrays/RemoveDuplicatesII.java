package org.abhishek.arrays;

import java.util.Arrays;

public class RemoveDuplicatesII {


    public int removeDuplicates(int[] nums) {

        int i = 0, k = 0;

        while (i < nums.length - 1) {
            int j = i;
            while (j < nums.length - 1) {
                if (nums[j] == nums[j + 1]) {
                    j++;
                } else {
                    break;
                }
            }
            if (j - i <= 1) {
                nums[k++] = nums[i++];
            } else {
                nums[k++] = nums[i];
                i = j;
            }
        }
        nums[k++] = nums[nums.length - 1];
        System.out.println(k);
        System.out.println(Arrays.toString(nums));

        return k;

    }

    public int removeDuplicatesII(int[] nums) {

        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;

    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3,3,3,3};
        int[] nums1 = {0,0,1,1,1,1,2,3};
        RemoveDuplicatesII removeDuplicates = new RemoveDuplicatesII();
        removeDuplicates.removeDuplicates(nums);
        removeDuplicates.removeDuplicates(nums1);

    }
}
