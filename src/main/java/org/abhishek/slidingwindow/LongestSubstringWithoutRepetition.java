package org.abhishek.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/*
Given a string s, find the length of the longest
substring
 without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LongestSubstringWithoutRepetition {

    public static int lengthOfLongestSubstring(String s) {

//        int maxLength = 0;
//        Map<Character, Integer> characterSet = new HashMap<>();
//
//        int left = 0, right = 0;
//        while (left <= right && right < s.length()) {
//            if (characterSet.containsKey(s.charAt(right))) {
//                maxLength = Math.max(maxLength, right - left);
//                System.out.println(s.substring(left, right));
//                left = characterSet.get(s.charAt(right)) + 1;
//                right = left;
//                characterSet.clear();
//            } else {
//                characterSet.put(s.charAt(right), right);
//                right++;
//            }
//        }
//        maxLength = Math.max(maxLength, right - left);
//
//        return maxLength;

        Set<Character> set = new HashSet<>();
        int result = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            result = Math.max(result, right - left + 1);
        }
        return result;

    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

}
