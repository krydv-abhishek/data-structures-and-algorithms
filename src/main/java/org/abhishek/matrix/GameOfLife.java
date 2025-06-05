package org.abhishek.matrix;

import java.util.Arrays;
/*
"The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board. In this process, births and deaths occur simultaneously.

Given the current state of the board, update the board to reflect its next state.

Note that you do not need to return anything.
 */
public class GameOfLife {
    public static void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = getLives(board, i, j, m, n);
                if (board[i][j] == 1 && (lives == 2 || lives == 3)) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2;
                }

            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }


    }

    public static int getLives(int[][] board, int i, int j, int m, int n) {
        int lives = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k >= 0 && l >= 0 && k < m && l < n && !(k == i && l == j)) {
                    lives += board[k][l] & 1;
                }
            }
        }
        return lives;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1}, {1, 0}};
        //int[][] matrix = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};

        gameOfLife(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
