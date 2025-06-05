package org.abhishek.backtracking;

public class NQueensII {

    public static int totalNQueens(int n) {

        int[] count = new int[1];

        boolean[] col = new boolean[n];
        boolean[] diagonal = new boolean[2 * n - 1];
        boolean[] antiDiagonal = new boolean[2 * n - 1];
        backtrack(0, count, col, diagonal, antiDiagonal, n);

        return count[0];
    }

    public static void backtrack(int index, int[] count,
                                 boolean[] col, boolean[] diagonal, boolean[] antiDiagonal, int n) {
        if (index == n) {
            count[0]++;
            return;
        }

        for (int i = 0; i < n; i++) {
            int d1 = index - i + n - 1;
            int d2 = index+i;

            if (!col[i] && !diagonal[d1] && !antiDiagonal[d2]) {
                col[i] = diagonal[d1] = antiDiagonal[d2] = true;
                backtrack(index + 1, count, col, diagonal, antiDiagonal, n);
                col[i] = diagonal[d1] = antiDiagonal[d2] = false;
            }
        }

    }


    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
}
