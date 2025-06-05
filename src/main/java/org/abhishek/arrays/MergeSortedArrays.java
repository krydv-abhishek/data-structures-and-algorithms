package org.abhishek.arrays;

import java.util.Arrays;

public class MergeSortedArrays {

    public void mergeSortedArrays(int[] nums1, int[] nums2, int m, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {

        int[] num1 = {2,3,5,5,0,0,0,0,0}, num2={3,4,5,7,9};
        int m=4, n=5;
        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        mergeSortedArrays.mergeSortedArrays(num1, num2, m, n);

    }

}