package org.abhishek.twoPointers;



/*

https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.
 */
public class MostWater {
    public static int maxArea(int[] height) {

        int left =0, right = height.length-1;
        int maxWater = 0;        

        while(left < right) {
            int containedWater = Math.min(height[left], height[right])*(right-left);

            if(maxWater < containedWater) {
                maxWater = containedWater;
            }

            if(height[left]< height[right]) { 
                left++;
            } else {
                right--;
            }

        }


        return maxWater;
        
    }

    public static void main(String[] args) {
        
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));

    }

}



