package org.abhishek.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombination {


    public static List<String> letterCombinations(String digits) {

        Map<Character, List<Character>> map = Map.of(
                '2', List.of('a','b','c'),
                '3', List.of('d','e','f'),
                '4', List.of('g','h','i'),
                '5', List.of('j','k','l'),
                '6', List.of('m','n','o'),
                '7', List.of('p','q','r','s'),
                '8', List.of('t', 'u','v'),
                '9', List.of('w','x','y','z')
        );

        List<String> answer = new ArrayList<>();

        if(digits.isEmpty()) {
            return answer;
        }
        backtrack(0, map, answer, digits, new StringBuilder());
        return answer;

    }

    public static void backtrack(int index, Map<Character, List<Character>> map,
                                 List<String> answer, String digits,
                                 StringBuilder currString) {

        if(currString.length()==digits.length()) {
            answer.add(currString.toString());
            return;
        }

        for(char c: map.get(digits.charAt(index))){
            currString.append(c);
            backtrack(index+1, map, answer, digits, currString);
            currString.deleteCharAt(currString.length()-1);

        }

    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("235"));
    }
}
