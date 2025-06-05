package org.abhishek.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptItself {

    public int[] productExceptSelf(int[] nums) {
        
        int sizeOfArray = nums.length;
        int[] resultArray = new int[sizeOfArray];

        resultArray[sizeOfArray-1] = nums[sizeOfArray-1];        
        
        for(int i=sizeOfArray-2; i>=0; i--) {
            resultArray[i] = nums[i] * resultArray[i+1];
        }

        System.out.println(Arrays.toString(resultArray));

        int prefixProduct = 1;

        for(int i=0; i<sizeOfArray-1; i++) {
            resultArray[i] = prefixProduct * resultArray[i+1];
            prefixProduct = prefixProduct * nums[i];
        }
        resultArray[sizeOfArray-1] = prefixProduct;
        return resultArray;

    }


    public static void main(String[] args) {

        int[] nums = {4,3,2,1,2};
        ProductOfArrayExceptItself object = new ProductOfArrayExceptItself();
        System.out.println(Arrays.toString(object.productExceptSelf(nums)));

    }
}
