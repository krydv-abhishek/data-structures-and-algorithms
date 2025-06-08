package org.abhishek.dp;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {

        int n = s.length();

        int[][] dp = new int[n][n];


        int subStringLength = 1;
        String answer = "";
        while (subStringLength <= n) {

            for (int i = 0; (i + subStringLength) <= s.length(); i++) {
                String substring = s.substring(i, subStringLength+i);
                if (substring.length() == 1) {
                    dp[i][i] = 1;
                    if(substring.length()>answer.length()) {
                        answer = substring;
                    }
                } else if (substring.length() == 2 && substring.charAt(0) == substring.charAt(1)) {
                    dp[i][i + 1] = 1;
                    if(substring.length()>answer.length()) {
                        answer = substring;
                    }
                } else if (substring.charAt(0) == substring.charAt(substring.length() - 1)
                        && dp[i + 1][i+subStringLength-2] == 1) {
                    dp[i][i+subStringLength-1] = 1;
                    if(substring.length()>answer.length()) {
                        answer = substring;
                    }
                }
            }
            subStringLength++;
        }

        return answer;

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abacdefdcf"));
    }
}
