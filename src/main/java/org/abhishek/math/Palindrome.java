package org.abhishek.math;

public class Palindrome {

    public static boolean isPalindrome(int x) {


        int on = x;
        int count = 0;
        while (x > 0) {
            x = x / 10;
            count++;
        }

        int d = (int)Math.pow(10, count-1);

        x=on;
        int n = 0;
        while (x > 0) {
            int r = x % 10;
            n = n + d * r;
            d = d / 10;
            x = x / 10;
        }
        return n == on;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1405041));
    }
}
