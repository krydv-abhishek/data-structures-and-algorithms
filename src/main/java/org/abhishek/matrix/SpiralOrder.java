package org.abhishek.matrix;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.

 */
public class SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        int si = 0, sj=0;
        int m= matrix.length;
        int n = matrix[0].length;
        int totalElements = m*n;
        int count = 0;

        while(count<totalElements) {
            int i = si, j=sj;
            while(j<n) {
                result.add(matrix[i][j++]);
                count++;
                if(count==totalElements)
                    return result;
            }
            j--;
            i++;
            while(i<m-1 && j==n-1) {
                result.add(matrix[i++][j]);
                count++;
                if(count==totalElements)
                    return result;
            }
            while(j>=sj && i==m-1) {
                result.add(matrix[i][j--]);
                count++;
                if(count==totalElements)
                    return result;
            }
            i--;
            j++;
            while(i>si && j==sj) {
                result.add(matrix[i--][j]);
                count++;
                if(count==totalElements)
                    return result;
            }
            si++;
            sj++;
            m--;
            n--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};

        System.out.println(spiralOrder(matrix));
    }
}
