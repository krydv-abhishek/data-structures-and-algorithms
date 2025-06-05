package org.abhishek.bitmanipulation;

public class HammingWeight {

    public static int hammingWeight(int n) {

        int count = 0;
        while(n>0) {
            int bit = n&1;
            if(bit==1) {
                count++;
            }

            n>>=1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(2147483645));
    }
}
