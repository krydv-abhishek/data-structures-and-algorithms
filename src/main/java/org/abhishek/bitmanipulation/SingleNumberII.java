package org.abhishek.bitmanipulation;

public class SingleNumberII {

    public static int singleNumber(int[] nums) {
        int answer = 0;

        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int n : nums) {
                sum = (sum + ((n>>i)&1));
            }
            sum = sum%3;
            sum = sum<<i;
            answer = answer | sum;
        }

        return answer;

    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 3, 5, 2, 5, 2};
        System.out.println(singleNumber(nums));
    }
}
