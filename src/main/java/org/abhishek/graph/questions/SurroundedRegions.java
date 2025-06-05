package org.abhishek.graph.questions;

import java.util.Arrays;


//dfs
public class SurroundedRegions {


    public static void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        char[][] emptyBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                emptyBoard[i][j]='X';
            }
        }

        for(int i=0; i<n; i++) {
            if(board[0][i]=='O') {
                dfs(emptyBoard, board, 0, i);
            }
        }
        for(int i=0; i<n; i++) {
            if(board[m-1][i]=='O') {
                dfs(emptyBoard, board, m-1, i);
            }
        }
        for(int i=1; i<m-1; i++) {
            if(board[i][0]=='O') {
                dfs(emptyBoard, board, i, 0);
            }
        }
        for(int i=1; i<m-1; i++) {
            if(board[i][n-1]=='O') {
                dfs(emptyBoard, board, i, n-1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(emptyBoard[i][j]=='O') {
                    board[i][j]='O';
                } else {
                    board[i][j]='X';
                }
            }
        }

    }

    public static void dfs(char[][] emptyBoard, char[][] grid, int r, int c) {
        if(r<0 || c<0 || r >= grid.length || c>=grid[0].length || grid[r][c]=='X') {
            return;
        }
        emptyBoard[r][c]='O';
        grid[r][c]='X';

        dfs(emptyBoard, grid, r+1, c);
        dfs(emptyBoard, grid, r-1, c);
        dfs(emptyBoard, grid, r, c+1);
        dfs(emptyBoard, grid, r, c-1);

    }

    public static void main(String[] args) {
//        char[][] grid = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}
//        };

        char[][] grid = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};

        solve(grid);
        System.out.println(Arrays.deepToString(grid));

    }


}
