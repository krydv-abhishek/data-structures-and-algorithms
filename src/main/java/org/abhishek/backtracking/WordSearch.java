package org.abhishek.backtracking;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {


        boolean found = false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    found = backtrack(0, board, word, i, j);
                    if (found) {
                        return found;
                    }
                }
            }
        }
        return found;
    }

    public static boolean backtrack(int index, char[][] board, String word, int r, int c) {


        if (index == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '1' || board[r][c] != word.charAt(index)) {
            return false;
        }
        char ch = board[r][c];

        board[r][c] = '1';

        if (backtrack(index + 1, board, word, r + 1, c) ||
                backtrack(index + 1, board, word, r - 1, c) ||
                backtrack(index + 1, board, word, r, c + 1) ||
                backtrack(index + 1, board, word, r, c - 1)) {
            return true;
        }

        board[r][c] = ch;
        return false;

    }


    public static void main(String[] args) {

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(exist(board, "BCCEP"));

    }
}
