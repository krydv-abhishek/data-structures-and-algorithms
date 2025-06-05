package org.abhishek.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> answer = new ArrayList<>();

        boolean[] col = new boolean[n];
        boolean[] diagonal = new boolean[2 * n - 1];
        boolean[] antiDiagonal = new boolean[2 * n - 1];
        backtrack(0, answer, col, diagonal, antiDiagonal, n, new ArrayList());

        return answer;
    }

    public static void backtrack(int index, List<List<String>> answer,
                                 boolean[] col, boolean[] diagonal, boolean[] antiDiagonal, int n, List<Integer> curr) {
        if (index == n) {
            answer.add(getSolution(curr));

            return;
        }

        for (int i = 0; i < n; i++) {
            int d1 = index - i + n - 1;
            int d2 = index+i;

            if (!col[i] && !diagonal[d1] && !antiDiagonal[d2]) {
                col[i] = diagonal[d1] = antiDiagonal[d2] = true;
                curr.add(i);
                backtrack(index + 1, answer, col, diagonal, antiDiagonal, n, curr);
                curr.remove(curr.size()-1);
                col[i] = diagonal[d1] = antiDiagonal[d2] = false;
            }
        }

    }

    private static List<String> getSolution(List<Integer> curr) {

        List<String> answer = new ArrayList<>();

        for(int i=0; i< curr.size();i++) {
            int colNumber = curr.get(i);
            StringBuilder stringBuilder = new StringBuilder();
            for(int j=0;j<curr.size();j++) {
                if(j==colNumber) {
                    stringBuilder.append('Q');
                } else {
                    stringBuilder.append('.');
                }
            }
            answer.add(stringBuilder.toString());
        }
        return answer;

    }


    public static void main(String[] args) {

        System.out.println(solveNQueens(4));
    }
}
