package org.abhishek.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> hash = new HashMap<>();
        Map<String, Character> hash1 = new HashMap<>();

        String[] arrayOfStrings = s.split(" ");
        int i = 0;
        for (String str : arrayOfStrings) {
            if(i>=pattern.length()) return false;
            Character chPattern = pattern.charAt(i++);
            if (hash.containsKey(chPattern)) {
                if (!(Objects.equals(hash.get(chPattern), str))) {
                    return false;
                }
            } else {
                if (hash1.containsKey(str)) {
                    return false;
                } else {
                    hash.put(chPattern, str);
                    hash1.put(str, chPattern);
                }
            }
        }
        return i == pattern.length();

    }

    public static void main(String[] args) {

        System.out.println(wordPattern("jquery", "jquery"));
    }
}
