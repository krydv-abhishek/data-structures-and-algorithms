package org.abhishek.twoPointers;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {

        int begin = 0;
        int end = s.length()-1;


        while(begin <= end) {

            while(end > 0 && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if(end == 0) {
                return true;
            }
            while(begin < (s.length()-1) && !Character.isLetterOrDigit(s.charAt(begin))) {
                begin++;
            }
            if(Character.toLowerCase(s.charAt(end)) == Character.toLowerCase(s.charAt(begin))) {
                end--;
                begin++;
            } else{
                return false;
            }

        }
        return true;   
    }
    // amanaplana c
    // analpanama
    

    public static void main(String[] args) {
        //he l  e  h
        //0123456789
        String str = "  ";

        System.out.println(isPalindrome(str));
    }
}
