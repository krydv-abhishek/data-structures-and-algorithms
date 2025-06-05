package org.abhishek.graph.questions;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] visited = new boolean[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            if (Objects.equals(wordList.get(i), beginWord)) {
                visited[i] = true;
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int numberOfTransFormations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String nextWord = queue.poll();
                if (Objects.equals(nextWord, endWord)) {
                    return numberOfTransFormations+1;
                }
                for (int j = 0; j < wordList.size(); j++) {
                    if (!visited[j] && isOneCharacterDiff(wordList.get(j), nextWord)) {
                        visited[j] = true;
                        queue.add(wordList.get(j));
                    }
                }
            }
            numberOfTransFormations++;

        }
        return 0;
    }

    public static boolean isOneCharacterDiff(String word1, String word2) {
        char[] word1Char = word1.toCharArray();
        char[] word2Char = word2.toCharArray();

        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1Char[i] != word2Char[i]) {
                diff++;
            }
        }
        return diff == 1;
    }

    public static void main(String[] args) {

        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength("hit", "cog", wordList));

    }
}
