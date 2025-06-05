package org.abhishek.arrays;

import java.util.Arrays;

public class MajorityElement {


    public int majorityElement(int[] nums) {

        Arrays.sort(nums);

        int count = 1;
        for(int i=1; i< nums.length; i++) {
            while(i< nums.length && nums[i]==nums[i-1]) {
                count++;
                i++;
            }
            if(count > nums.length/2) {
                return nums[i-1];
            } else {
                count = 1;
            }
        }
        return nums[nums.length -1];

    }


    public static void main(String[] args) {

        int[] nums = {1, 1, 3, 2, 2, 3,3,3,3};
        MajorityElement majorityElement = new MajorityElement();
        majorityElement.majorityElement(nums);


    }
}
