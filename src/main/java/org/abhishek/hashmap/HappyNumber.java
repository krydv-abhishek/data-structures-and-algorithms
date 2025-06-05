package org.abhishek.hashmap;

import java.util.*;

public class HappyNumber {

    public static boolean isHappy(int n) {
        Set<Integer> hash =  new HashSet<>();
        int sum = getSum(n);
        while(sum != 1) {
            if(hash.contains(sum)) {
                return false;
            }
            hash.add(sum);
            sum = getSum(sum);
        }
        return true;
    }

    public static int getSum(int n) {
        int sum = 0;
        while(n>0) {
            sum+= (int)Math.pow(n%10, 2);
            n/=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
