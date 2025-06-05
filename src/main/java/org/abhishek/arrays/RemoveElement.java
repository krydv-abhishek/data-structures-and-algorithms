package org.abhishek.arrays;

import java.util.Arrays;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return index;

    }

    public static void main(String[] args) {

        int[] nums = {2,3,5,7,5};
        int val=7;
        RemoveElement removeElement = new RemoveElement();
        removeElement.removeElement(nums, val);

    }
}
