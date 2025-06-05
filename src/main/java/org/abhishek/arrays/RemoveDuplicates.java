package org.abhishek.arrays;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int i = 0, k = 0;

        while (i < nums.length - 1) {
            if (nums[i] == nums[i + 1]) {
                i++;
                continue;
            }

            nums[k++] = nums[i++];
        }
        nums[k++] = nums[nums.length - 1];

        return k;

    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 5, 7, 5};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        removeDuplicates.removeDuplicates(nums);

    }
}
