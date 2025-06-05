package org.abhishek.math;

public class Power {

    public static double myPow(double x, int n) {

        if (n <0) {
            return myPowHelper(1/x, -n);
        }
        return myPowHelper(x, n);
    }

    public static double myPowHelper(double x, int n) {

        if (n == 0) {
            return x;
        }
        if (n == 1) {
            return x;
        }
        double pw = myPow(x, n / 2);
        if (n % 2 == 0) {
            return pw * pw;
        } else {
            return pw * pw * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, -2));
    }
}
