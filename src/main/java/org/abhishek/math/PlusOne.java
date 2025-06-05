package org.abhishek.math;

import java.util.Arrays;

public class PlusOne {

    public static int[] plusOne(int[] digits) {

        int[] answer = new int[digits.length + 1];

        int c = 1;
        for (int i = digits.length - 1; i >= 0; i--) {

            int currentDigit = c + digits[i];
            answer[i+1] = currentDigit % 10;
            if (currentDigit > 9) {
                c = 1;
            } else {
                c = 0;
            }

        }

        if(c==1) {
            answer[0] =1;
        } else {
            return Arrays.copyOfRange(answer, 1, digits.length+1);
        }
        return answer;

    }

    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
