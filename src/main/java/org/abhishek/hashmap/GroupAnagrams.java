package org.abhishek.hashmap;

import java.util.*;


/*/
Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hash = new HashMap<>();

        for (String str : strs) {
            String sortedStr = sortString(str);
            List<String> anagramList = hash.getOrDefault(sortedStr, null);
            if (anagramList == null) {
                List<String> strFirst = new ArrayList<>();
                strFirst.add(str);
                hash.put(sortedStr, strFirst);
            } else {
                anagramList.add(str);
            }
        }
        return new ArrayList<>(hash.values());
    }

    public static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
