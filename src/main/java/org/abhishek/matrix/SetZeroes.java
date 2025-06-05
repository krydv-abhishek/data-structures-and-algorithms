package org.abhishek.matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetZeroes {
    public static void setZeroes(int[][] matrix) {

        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }

        }
//        System.out.println(rowSet);
//        System.out.println(colSet);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        //int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] matrix = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
        //int[][] matrix = {{1}};

        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
