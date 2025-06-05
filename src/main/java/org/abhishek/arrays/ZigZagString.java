package org.abhishek.arrays;

public class ZigZagString {
    public static String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }
        String answer = "";
        int i = 0;
        int indexToBeAdded = 0;
        int offset = 2 * numRows - 2;
        while (i < numRows) {
            indexToBeAdded = i;
            while ((indexToBeAdded -2*i) < s.length()) {
                if (i>0 && i < numRows -1 && indexToBeAdded > i) {
                    answer = answer + s.charAt(indexToBeAdded - 2*i);
                }
                if (indexToBeAdded < s.length()) {
                    answer = answer + s.charAt(indexToBeAdded);
                }
                indexToBeAdded = indexToBeAdded + offset;
            }
            i++;

        }
        return answer;

    }

    public static void main(String[] args) {

        String strs = "MANMYTHLEGENDGOD";
        System.out.println(convert(strs, 8));

    }
}
