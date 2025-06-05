package org.abhishek.arrays;

import java.util.Arrays;

public class RotateArrays {

    public void rotate(int[] nums, int k) {

        int arraySize = nums.length;

        int startPointer = 0, endPointer = arraySize - 1;

        reverseArrayInPlace(nums, startPointer, arraySize - k - 1);
        System.out.println(Arrays.toString(nums));
        reverseArrayInPlace(nums, arraySize - k, endPointer);
        System.out.println(Arrays.toString(nums));
        reverseArrayInPlace(nums, startPointer, endPointer);


    }

    public void reverseArrayInPlace(int[] nums, int startIndex, int endIndex) {

        while (startIndex <= endIndex) {
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        RotateArrays rotateArrays = new RotateArrays();
        rotateArrays.rotate(nums, 4);
        System.out.println(Arrays.toString(nums));

    }
}
