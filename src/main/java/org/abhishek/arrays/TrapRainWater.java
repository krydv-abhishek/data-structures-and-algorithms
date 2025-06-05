package org.abhishek.arrays;

public class TrapRainWater {

    public int trap(int[] height) {

        if (height.length < 3) {
            return 0;
        }

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int min = 0;
        int max = 0;
        int totalArea = 0;

        for (int i = 0; i < height.length; i++) {
            if (height[i] > min) {
                min = height[i];
            }
            leftMax[i] = min;

            if (height[height.length - i - 1] > max) {
                max = height[height.length - i - 1];
            }
            rightMax[height.length - i - 1] = max;
        }

        for (int i = 0; i < height.length; i++) {
            totalArea = totalArea + (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }

        return totalArea;

    }

    public static void main(String[] args) {
        TrapRainWater trapRainWater = new TrapRainWater();

        int[] height = { 5, 4, 1, 2 };
        System.out.println(trapRainWater.trap(height));
    }

}
