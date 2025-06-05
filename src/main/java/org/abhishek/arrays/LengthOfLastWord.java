package org.abhishek.arrays;

public class LengthOfLastWord {


    public static int lengthOfLastWord(String s) {

        String[] words = s.split("\\s+");
        return words[words.length-1].length();
        
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLastWord("luffy is still joyboy"));

    }
    
}
