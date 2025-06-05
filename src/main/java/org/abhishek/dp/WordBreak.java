package org.abhishek.dp;

import java.util.List;

public class WordBreak {


    public static boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length()+1];
        dp[0]= true;
        for(int i = 1; i<=s.length();i++) {
            for (String word : wordDict) {
                if (i>=word.length() && s.substring(i - word.length(), i).equals(word) && dp[i - word.length()]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];

    }


    public static void main(String[] args) {

        List<String> wordDict = List.of("leet", "co" ,"et" , "de");

        System.out.println(wordBreak("leetcode", wordDict));
    }
}
