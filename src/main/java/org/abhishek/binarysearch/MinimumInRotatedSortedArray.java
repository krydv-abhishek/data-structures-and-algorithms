package org.abhishek.binarysearch;

public class MinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {

        int start = 0;
        int end = nums.length-1;

        while(start<=end) {

            int mid = (start+end)/2;
            int midVal = nums[mid];

            if(nums[start]<=nums[end]) {
                return nums[start];
            } else {

                if(midVal>=nums[start] && midVal>=nums[end]) {
                    start = mid+1;
                } else {
                    end = mid;
                }
            }
        }
        return nums[start];
    }


    public static void main(String[] args) {

        int[] nums = {4,5,6,7,1,2};
        System.out.println(findMin(nums));



    }
}
