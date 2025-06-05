package org.abhishek.graph.questions;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    public static int snakesAndLadders(int[][] board) {

        int n = board.length;
        int target = n * n;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[target + 1];

        queue.add(1);
        visited[1]=true;

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int k=0; k< size; k++) {
                Integer node = queue.poll();
                if (target == node) {
                    return steps;
                }
                int i =0;
                while (i<6 && (node+i+1 <= target)) {
                    int nextStep;
                    Integer boardNumber = getNextStep(node+i+1, board);
                    if (boardNumber != -1) {
                        nextStep = boardNumber;
                    } else {
                        nextStep = node + i + 1;
                    }
                    if (!visited[nextStep]) {
                        visited[nextStep] = true;
                        queue.add(nextStep);
                    }
                    i++;
                }
            }
            steps++;
        }
        return steps;

    }

    private static Integer getNextStep(Integer node, int[][] board) {
        int n = board.length;

        int rowNumber = n- ((node - 1) / n) -1;
        int colNumber = ((node - 1) / n) % 2 == 0 ? (node - 1) % n : n - ((node - 1) % n + 1);
        return board[rowNumber][colNumber];

    }

    public static void main(String[] args) {

        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };

        System.out.println(snakesAndLadders(board));

    }


}
