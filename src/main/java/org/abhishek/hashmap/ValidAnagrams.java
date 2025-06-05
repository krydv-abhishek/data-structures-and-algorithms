package org.abhishek.hashmap;

public class ValidAnagrams {

    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        int[] hash = new int[26];

        for(int i = 0; i< s.length();i++) {
            hash[s.charAt(i) - 97]++;
            hash[t.charAt(i) - 97]--;
        }

        for(int i = 0; i< 26;i++) {
            if(hash[i]!=0){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
