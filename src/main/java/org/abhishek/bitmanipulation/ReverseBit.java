package org.abhishek.bitmanipulation;

public class ReverseBit {
    public static int reverseBits(int n) {

        int answer = 0;

        for(int i =0;i <32; i++) {

            int currentBit = n & 1;
            //System.out.println(String.format("%32s", Integer.toBinaryString(answer)).replace(' ', '0'));
            answer = (answer << 1) | currentBit;
            n = n>>1;

        }

        return answer;

    }

    public static void main(String[] args) {
        System.out.println(String.format("%32s", Integer.toBinaryString(8)).replace(' ', '0'));
        System.out.println(String.format("%32s", Integer.toBinaryString(reverseBits(8))).replace(' ', '0'));
    }
}
