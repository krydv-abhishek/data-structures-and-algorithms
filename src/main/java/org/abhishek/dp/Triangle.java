package org.abhishek.dp;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {

        int lastRowSize = triangle.size();

        int[][] dp = new int[lastRowSize][lastRowSize];
        dp[0][0] = triangle.get(0).get(0);
        int i = 1;
        while (i < lastRowSize) {
            List<Integer> numbersAtIthRow = triangle.get(i);
            int numberAtIthRowSize = numbersAtIthRow.size();
            for (int j = 0; j < numberAtIthRowSize; j++) {
                Integer number = numbersAtIthRow.get(j);
                if (j == 0) {
                    dp[i][j] = number + dp[i - 1][j];
                } else if (j == numberAtIthRowSize - 1) {
                    dp[i][j] = number + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = number + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }

            }
            i++;
        }

        int answer = Integer.MAX_VALUE;
        for (int k = 0; k < lastRowSize; k++) {
            answer = Math.min(dp[lastRowSize - 1][k], answer);
        }
        return answer;
    }


    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(8, 5));
        triangle.add(List.of(-100, 6, 200));
        System.out.println(minimumTotal(triangle));

    }
}
