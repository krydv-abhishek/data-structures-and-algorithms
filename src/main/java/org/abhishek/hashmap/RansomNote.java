package org.abhishek.hashmap;

import java.util.Arrays;

public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] hash = new int[26];
        System.out.println(Arrays.toString(hash));

        for(int i = 0; i< magazine.length();i++) {
            hash[magazine.charAt(i) - 97]++;
        }
        System.out.println(Arrays.toString(hash));

        for(int i = 0; i< ransomNote.length();i++) {
            int index = ransomNote.charAt(i) - 97;
            if(hash[index]<=0) {
                return false;
            }
            hash[index]--;
        }
        return true;
    }

    public static void main(String[] args) {

        //System.out.println('a'-1);
        System.out.println(canConstruct("aa", "aab"));
    }
}
