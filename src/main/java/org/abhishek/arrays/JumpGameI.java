package org.abhishek.arrays;

public class JumpGameI {

    public static boolean canJump(int[] nums) {

        if (nums.length == 1) {
            return true;
        }

        int max = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (max < i) {
                return false;
            }
            if (max < i + nums[i]) {
                max = i + nums[i];
            }
        }

        return max >= nums.length - 1;
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 6, 5, 0, 3};
        System.out.println(canJump(nums));

    }

}
