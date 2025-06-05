package org.abhishek.binarysearch;

import java.util.Arrays;

public class AggressiveBalls {

    public static int maxDistance(int[] position, int m) {

        Arrays.sort(position);
        int start = 1;
        int end = position[position.length - 1] - position[0];
        int result = 0;

        while (start <= end) {
            int maxDistance = (start + end) >>> 1;

            if (canPlaceBalls(position, m, maxDistance)) {
                result = maxDistance;
                start = maxDistance + 1;
            } else {
                end = maxDistance - 1;
            }
        }
        return result;
    }

    public static boolean canPlaceBalls(int[] position, int m, int maxDistance) {

        int prevPosition = position[0];
        int count = 1;
        for (int i = 1; i < position.length; i++) {
            if (position[i] - prevPosition >= maxDistance) {
                prevPosition = position[i];
                count++;
            }

            if (count == m) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] pos = {1, 2, 4, 8, 9};
        System.out.println(maxDistance(pos, 3));

    }
}
