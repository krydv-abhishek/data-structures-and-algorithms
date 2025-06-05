package org.abhishek.matrix;

import java.util.Arrays;

/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.



Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

 */
public class RotateMatrix {

//    public static void rotate(int[][] matrix) {
//        int t1, t2, t3;
//        int m = matrix.length;
//        int mReducing = m - 1;
//        for (int j = 0; j < m / 2; j++) {
//            for (int i = j; i < mReducing; i++) {
//                t1 = matrix[j][i];
//                t2 = matrix[i][m - j - 1];
//                t3 = matrix[m - j - 1][m - i - 1];
//                matrix[j][i] = matrix[m - i - 1][j];
//                matrix[m - i - 1][j] = t3;
//                matrix[m - j - 1][m - i - 1] = t2;
//                matrix[i][m - j - 1] = t1;
//                System.out.println(Arrays.deepToString(matrix));
//            }
//            mReducing--;
//        }
//
//    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }

    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        //int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //int[][] matrix = {{1}};

        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
