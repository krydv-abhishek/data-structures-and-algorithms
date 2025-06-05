package org.abhishek.hashmap;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    public static boolean isIsomorphic(String s, String t) {

        Map<Character, Character> hash = new HashMap<>();
        Map<Character, Character> hash1 = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            Character chSource = s.charAt(i);
            Character chTarget = t.charAt(i);
            if (hash.containsKey(chSource)) {
                if (!(hash.get(chSource) == chTarget)) {
                    return false;
                }
            } else {
                if (hash1.containsKey(chTarget)) {
                    return false;
                } else {
                    hash.put(chSource, chTarget);
                    hash1.put(chTarget, chSource);

                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isIsomorphic("badc", "baba"));
    }
}
