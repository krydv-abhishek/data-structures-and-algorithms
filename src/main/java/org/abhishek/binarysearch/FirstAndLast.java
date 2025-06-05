package org.abhishek.binarysearch;

import java.util.Arrays;

public class FirstAndLast {

    public static int[] searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int[] answer = new int[2];
        answer[0] = -1;
        answer[1] = -1;


//        while (start <= end) {
//            int mid = (end + start) >>> 1;
//            int midVal = nums[mid];
//
//            if (midVal == target) {
//                if (mid == 0 || midVal > nums[mid - 1]) {
//                    answer[0] = mid;
//                    break;
//                } else {
//                    end = mid - 1;
//                }
//            } else if (midVal > target) {
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//        }
        // Lower Bound
        while (start <= end) {
            int mid = (end + start) >>> 1;
            int midVal = nums[mid];
            // Go left, exclude current.
            if (midVal > target || (midVal == target) && (mid != 0 && nums[mid - 1] == nums[mid])) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        answer[0] = nums[start];

        start = 0;
        end = nums.length - 1;

        while (start <= end) {
            int mid = (end + start) >>> 1;
            int midVal = nums[mid];

            if (midVal == target) {
                if (mid == nums.length - 1 || midVal < nums[mid + 1]) {
                    answer[1] = mid;
                    break;
                } else {
                    start = mid + 1;
                }
            } else if (midVal > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }




        return answer;


    }

    public static void main(String[] args) {

        int[] nums = {1, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8};
        System.out.println(Arrays.toString(searchInsert(nums, 8)));


    }
}
