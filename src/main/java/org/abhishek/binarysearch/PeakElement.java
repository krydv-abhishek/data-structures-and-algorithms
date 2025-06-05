package org.abhishek.binarysearch;

public class PeakElement {

    public static int findPeakElement(int[] nums) {

        int start = 0;
        int end = nums.length-1;

        while(start<=end) {

            int mid = (start+end)/2;
            int midVal = nums[mid];

            if(midVal>= getVal(nums, mid-1) && midVal >= getVal(nums, mid+1)) {
                return midVal;
            } else if(getVal(nums, mid-1) > midVal) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return nums[start];
    }

    public static int getVal(int[] nums, int index) {
        int n =nums.length;
        if(index==-1 || index==n) {
            return Integer.MIN_VALUE;
        }
        return nums[index];
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,3,2};
        System.out.println(findPeakElement(nums));



    }
}
