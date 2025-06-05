package org.abhishek.bitmanipulation;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int answer = 0;

        for(int n : nums) {
            answer = answer ^ n;
        }

        return answer;

    }

    public static void main(String[] args) {
        int[] nums = {2,5,3,2,3};
        System.out.println(singleNumber(nums));
    }
}
