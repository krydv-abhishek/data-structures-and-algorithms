package org.abhishek.binarysearch;

public class SearchInRotatedSortedArray {

    public static int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (end + start) >>> 1;
            int midVal = nums[mid];

            if (midVal == target) {
                return mid;
            } else if(midVal>=nums[start]) {
                if(target>=nums[start] && target<midVal) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else {
                if(target<=nums[end] && target>midVal) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }

        }
        return -1;

    }

    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 8, 9, 0, 1, 2, 3};
        System.out.println(searchInsert(nums, 3));


    }
}
