package org.abhishek.math;


public class MaxPoints {

    public static int maxPoints(int[][] points) {

        int max = 1;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {

                double deltaX = points[j][0] - points[i][0];
                double gradient;
                if (deltaX != 0.0) {
                    gradient = ((double) (points[j][1] - points[i][1]) / deltaX);
                } else {
                    gradient = Integer.MIN_VALUE;
                }
                int count = 2;
                for (int k = j + 1; k < points.length; k++) {
                    double deltaK = points[k][0] - points[i][0];
                    double gradientItr;
                    if (deltaX != 0.0) {
                        gradientItr = ((double) (points[k][1] - points[i][1]) / deltaK);
                    } else {
                        gradientItr = Integer.MIN_VALUE;
                    }
                    if (gradientItr == gradient) {
                        count++;
                    }
                }
                max = Math.max(max, count);
            }
        }


        return max;

    }

    public static void main(String[] args) {

        //int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        int[][] points = {{0, 1}, {0, 0}, {0, 4}, {0, -2}, {0, -1}, {0, 3}, {0, -4}};
        System.out.println(maxPoints(points));

    }
}
