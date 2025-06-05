package org.abhishek.binarysearch;

public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m*n-1;

        while (start <= end) {
            int mid = (end + start) >>> 1;
            int midVal = matrix[mid/n][mid%n];

            if (midVal > target) {
                end = mid - 1;
            } else if (midVal < target) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println(searchMatrix(matrix, 12));


    }
}
