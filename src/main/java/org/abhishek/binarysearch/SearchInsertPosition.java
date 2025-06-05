package org.abhishek.binarysearch;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (end + start) >>> 1;
            int midVal = nums[mid];

            if (midVal > target) {
                end = mid - 1;
            } else if (midVal < target) {
                start = mid + 1;
            } else {
                return mid + 1;
            }
        }
        return start + 1;

    }

    public static void main(String[] args) {

        int[] nums = {1,5,6,7,10};
        System.out.println(searchInsert(nums, 0));



    }
}
