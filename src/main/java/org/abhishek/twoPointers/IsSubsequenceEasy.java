package org.abhishek.twoPointers;

public class IsSubsequenceEasy {
    public static boolean isSubsequence(String s, String t) {
        
        int i = 0;
        int j = 0;

        if(t.length() == 0 || s.length() == 0) {
            return true;
        } 

        while(i < t.length()) {

            if(t.charAt(i) == s.charAt(j)) {
                j++;
            }
            if(j==s.length()){
                return true;
            }
            i++;
        } 

        return false;     
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgd"));
    }
}
