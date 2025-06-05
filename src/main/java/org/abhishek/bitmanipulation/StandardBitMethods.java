package org.abhishek.bitmanipulation;


class BitOperator {


    public BitOperator() {
    }

    void andOperator(int m, int n) {
        System.out.println("AND operator");
        System.out.println(Integer.toBinaryString(m));
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(m & n));
        System.out.println(" ");
    }

    void orOperator(int m, int n) {
        System.out.println("OR operator");
        System.out.println(Integer.toBinaryString(m));
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(m | n));
        System.out.println(" ");
    }

    /*
    A number XOR-ed with itself is 0: x ^ x = 0
    A number XOR-ed with 0 is the number itself: x ^ 0 = x
    XOR is commutative and associative:
     */
    void xorOperator(int m, int n) {
        System.out.println("XOR operator");
        System.out.println(Integer.toBinaryString(m));
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(m ^ n));
        System.out.println(" ");
    }

    void negationOperator(int m) {
        System.out.println("Negation operator");
        System.out.println(Integer.toBinaryString(m));
        System.out.println(Integer.toBinaryString(~m));
        System.out.println(" ");
    }

    void leftShiftOperator(int m) {
        System.out.println("Left Shift operator");
        System.out.println(Integer.toBinaryString(m));
        System.out.println(Integer.toBinaryString(m << 1));
        System.out.println(" ");
    }

    void rightShiftOperator(int m) {
        System.out.println("Right Shift operator");
        System.out.println(Integer.toBinaryString(m));
        System.out.println(Integer.toBinaryString(m >> 1));
        System.out.println(" ");
    }

    void signedInteger(int m) {
        /*
        Example: -3 in 4-bit:

        3 = 0011
        Flip = 1100 - 1's complement
        Add 1 = 1101 → that's -3 - 2's complement
         */
        System.out.println("Signed integer");
        System.out.println(Integer.toBinaryString(m));
        System.out.println("Negative integer");
        System.out.println(Integer.toBinaryString(~m + 1));

        m = -m;
        System.out.println("Positive integer");
        System.out.println(Integer.toBinaryString(~m + 1));

        System.out.println(" ");
    }

}

class BitAlgorithms {

    public BitAlgorithms() {
    }

    void setABitNumber(int num, int pos) {
        System.out.println("Set bit at position " + pos);
        System.out.println(Integer.toBinaryString(num));
        num |= (1 << pos);
        System.out.println(Integer.toBinaryString(num));
        System.out.println(" ");
    }

    void unsetABitNumber(int num, int pos) {
        System.out.println("Unset bit at position " + pos);
        System.out.println(Integer.toBinaryString(num));
        num &= (~(1 << pos));
        System.out.println(Integer.toBinaryString(num));
        System.out.println(" ");
    }

    void toggleBitNumber(int num, int pos) {
        System.out.println("Toggle bit at position " + pos);
        System.out.println(Integer.toBinaryString(num));
        num ^= (1 << pos);
        System.out.println(Integer.toBinaryString(num));
        System.out.println(" ");
    }

    void checkIfBitIsSetORUnset(int num, int pos) {
        System.out.println("Check bit is set or not at position " + pos);
        System.out.println(Integer.toBinaryString(num));
        int bit = num & (1 << pos);
        if (bit != 0) {
            System.out.println("Bit is set");
        } else {
            System.out.println("Bit is not set");
        }
        System.out.println(" ");
    }

    void computeXOR(int n) {
        System.out.println("Compute xor from 1 to " + n);
        if (n % 4 == 0)
            System.out.println(n);
        if (n % 4 == 1)
            System.out.println(1);
        if (n % 4 == 2)
            System.out.println(n + 1);
        else
            System.out.println(0);
        System.out.println(" ");
    }

    void isPowerOfTwo(int n) {
        System.out.println("Check if " + n + " is power of two");
        boolean flag = n != 0 && ((n & (n - 1)) == 0);
        if (flag) {
            System.out.println(n + " is a power of two");
        } else {
            System.out.println(n + " is not a power of two");
        }
        System.out.println(" ");
    }

    void countSetBits(int n) {
        System.out.println("Counting total number of set bits for " + n);
        int count = 0;
        while (n > 0) {
            count += n & 1;
            // Using the right shift operator.
            // The bits will be shifted one position to the
            // right.
            n >>= 1;
        }
        System.out.println("Total number of set bits " + count);
        System.out.println(" ");
    }

    void positionOfRightmostSetBit(int n) {

        /*
        00010100    &               (n = 20)
        00010011                     (n-1 = 19)
        -------------------
        00010000    ^                (XOR result number with n)
        00010100
        -------------------
        00000100 ------->  rightmost set bit will tell us the position
         */
        System.out.println("Finding position of rightmost set bit");
        // if the number is odd, return 1
        if ((n & 1) != 0) {
            System.out.println("Position of rightmost set bit is: 1");
        }

        n = n ^ (n & (n - 1));
        int pos = 0;
        while (n != 0) {
            n = n >> 1;
            pos++;
        }
        System.out.println("Position of rightmost set bit is: " + pos);
        System.out.println(" ");
    }

}

public class StandardBitMethods {

    public static void main(String[] args) {
        BitOperator bitOperator = new BitOperator();
        bitOperator.andOperator(5, 6);
        bitOperator.orOperator(5, 6);
        bitOperator.xorOperator(5, 6);
        bitOperator.negationOperator(1);

        bitOperator.leftShiftOperator(5);
        bitOperator.rightShiftOperator(5);

        bitOperator.signedInteger(5);

//        BitAlgorithms bitAlgorithms = new BitAlgorithms();
//        bitAlgorithms.setABitNumber(5, 1);
//        bitAlgorithms.unsetABitNumber(5, 0);
//        bitAlgorithms.toggleBitNumber(5, 1);
//        bitAlgorithms.checkIfBitIsSetORUnset(5, 1);
//        bitAlgorithms.computeXOR(5);
//        bitAlgorithms.isPowerOfTwo(4);
//        bitAlgorithms.countSetBits(6);
//        bitAlgorithms.positionOfRightmostSetBit(6);

    }

}
