package org.abhishek.slidingwindow;

import java.util.*;

/*
You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.



Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]

Output: [0,9]

Explanation:

The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]

Output: []

Explanation:

There is no concatenated substring.

Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]

Output: [6,9,12]

Explanation:

The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].



Constraints:

1 <= s.length <= 104
1 <= words.length <= 5000
1 <= words[i].length <= 30
s and words[i] consist of lowercase English letters.
 */
public class SubstringWithAllWords {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word,0)+1);
        }
        int wordLength = words[0].length();
        int concatenatedStringSize = words.length * wordLength;
        int left = 0;
        int right = wordLength - 1;

        while (left <= right && right < s.length()) {

            String currentString = s.substring(left, right+1);
            if (wordCount.containsKey(currentString)) {
                if (concatenatedStringFound(wordCount, s, concatenatedStringSize, wordLength, left)) {
                    result.add(left);
                    left ++;
                    right = left + wordLength - 1;
                    continue;
                }
            }
            right++;
            left++;
        }

        return result;

    }

    private static boolean concatenatedStringFound(Map<String, Integer> wordCount,
                                                   String s, int concatenatedStringSize,
                                                   int wordLength, int startPrefix) {
        Map<String, Integer> occurrenceCount = new HashMap<>();
        int i = 0;
        while (i < concatenatedStringSize && i + startPrefix + wordLength <= s.length()) {
            String currentString = s.substring(i + startPrefix, i + startPrefix + wordLength);
            if (wordCount.containsKey(currentString)) {
                occurrenceCount.put(currentString, occurrenceCount.getOrDefault(currentString,0)+1);
                i = i + wordLength;
            } else {
                return false;
            }
        }

        boolean answer = false;
        if(i == concatenatedStringSize) {
            for (Map.Entry<String, Integer> set : wordCount.entrySet()) {
                if(occurrenceCount.containsKey(set.getKey())
                        && Objects.equals(occurrenceCount.get(set.getKey()), set.getValue())) {
                    answer = true;
                } else {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }

//    public List<Integer> findSubstring(String s, String[] words) {
//        List<Integer> ans = new ArrayList<>();
//        int n = s.length();
//        int m = words.length;
//        int w = words[0].length();
//
//        HashMap<String,Integer> map = new HashMap<>();
//        for(String x : words)
//            map.put(x, map.getOrDefault(x,0)+1);
//
//        for(int i=0; i<w; i++){
//            HashMap<String,Integer> temp = new HashMap<>();
//            int count = 0;
//            for(int j=i,k=i; j+w <= n; j=j+w){
//                String word = s.substring(j,j+w);
//                temp.put(word,temp.getOrDefault(word,0)+1);
//                count++;
//
//                if(count==m){
//                    if(map.equals(temp)){
//                        ans.add(k);
//                    }
//                    String remove = s.substring(k,k+w);
//                    temp.computeIfPresent(remove, (a, b) -> (b > 1) ? b - 1 : null);
//                    count--;
//                    k=k+w;
//                }
//            }//inner for loop
//        }//outer for loop
//        return ans;
//    }//method


    public static void main(String[] args) {
        String[] words = {"aa","aa"};

        System.out.println(findSubstring("aaaaaaaaaaaaaa", words));
    }
}
