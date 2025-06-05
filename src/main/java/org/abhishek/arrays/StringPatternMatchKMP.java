package org.abhishek.arrays;

import java.util.Arrays;

public class StringPatternMatchKMP {
    public static int strStr(String haystack, String needle) {

        int haystackSize = haystack.length();
        int[] lpsArray = getLPSArray(needle);
        System.out.println(Arrays.toString(lpsArray));
        needle = " ".concat(needle);

        int i = 0;
        int j = 0;
        while (i < haystackSize) {
            if (haystack.charAt(i) == needle.charAt(j + 1)) {

                j++;
                i++;
                if (j == needle.length() - 1) {
                    return i - j;
                }

            } else {
                if (j > 0) {
                    j = lpsArray[j];
                } else {
                    i++;
                }
            }
        }

        return -1;

    }

    private static int[] getLPSArray(String pattern) {

        // a b c d a b c
        // 0 0 0 0 1 2 3

        // a a a a b a a
        // 0 1 2 3 0 0 1
        // 0 1 2 3 4 5 6

        // a a c d b a a c b a a c d b
        // 0 1 0 0 1 0 1 2 0 0 1 2 3 4

        int patternSize = pattern.length();
        int[] lps = new int[patternSize + 1];

        Arrays.fill(lps, 0);
        int backTrackIndex = 0;
        int i = 2;
        while (i < patternSize + 1) {
            if (pattern.charAt(i - 1) == pattern.charAt(backTrackIndex)) {
                backTrackIndex++;
                lps[i] = backTrackIndex;
                i++;
            } else {
                if (backTrackIndex != 0) {
                    backTrackIndex = lps[backTrackIndex];
                } else {
                    lps[i] = backTrackIndex;
                    i++;
                }
            }
        }
        return lps;

    }

    public static void main(String[] args) {

        System.out.println(strStr("ababcabcabababd", "ababd"));
        System.out.println(strStr("aabaaabaaac", "aabaaac"));

    }
}
