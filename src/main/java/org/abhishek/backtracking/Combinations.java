package org.abhishek.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> answer = new ArrayList<>();
        backtrack(1, answer, n, k, new ArrayList<>());
        return answer;

    }

    public static void backtrack(int index,
                          List<List<Integer>> answer, int n, int k,
                          List<Integer> currList) {

        if (currList.size() == k) {
            answer.add(new ArrayList<>(currList));
            //System.out.println(currList);
            return;
        }

        for (int i = index; i <= n; i++) {
            currList.add(i);
            backtrack(i + 1, answer, n, k, currList);
            currList.remove(currList.size() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}
