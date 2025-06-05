package org.abhishek.math;

public class TrailingZeros {

    public static int trailingZeroes(int n) {

        int answer = 0;
        while (n > 0) {
            n /= 5;
            answer += n;
        }
        return answer;

    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(998));

    }
}
