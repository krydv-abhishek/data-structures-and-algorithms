package org.abhishek.graph.questions;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class MinimumGeneticMutation {

    public static int minMutation(String startGene, String endGene, String[] bank) {

        boolean[] visited = new boolean[bank.length];
        for (int i = 0; i < bank.length; i++) {
            if (Objects.equals(bank[i], startGene)) {
                visited[i] = true;
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        int numberOfMutation = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String mutation = queue.poll();
                if (Objects.equals(mutation, endGene)) {
                    return numberOfMutation;
                }
                for (int j = 0; j < bank.length; j++) {
                    if (!visited[j] && isOneCharacterDiff(bank[j], mutation)) {
                        visited[j] = true;
                        queue.add(bank[j]);
                    }
                }
            }
            numberOfMutation++;

        }
        return -1;
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

        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(minMutation("AACCGGTT", "AAACGGTA", bank));

    }
}
