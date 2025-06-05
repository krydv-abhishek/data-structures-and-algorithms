package org.abhishek.bitmanipulation;

public class RangeBitWiseAnd {

    public static int rangeBitwiseAnd(int left, int right) {

        int answer = 0;
        for (int i = 31; i >= 0; i--) {
            int bitmask = (1 << i);
            if ((bitmask & left) != 0 && (bitmask & right) != 0 && right - left <= bitmask) {
                answer |= bitmask;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
    }
}
