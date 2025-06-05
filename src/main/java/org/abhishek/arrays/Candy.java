package org.abhishek.arrays;

import java.util.Arrays;

public class Candy {

    public int candy(int[] ratings) {

        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i + 1] < ratings[i]) {
                if(candies[i]<=candies[i+1]) {
                    candies[i] = candies[i+1] + 1;
                }
            }
        }

        System.out.println(Arrays.toString(candies));
        return Arrays.stream(candies).sum();

    }

    public static void main(String[] args) {
        Candy candy = new Candy();

        int[] ratings = { 100, 80, 70, 60, 70, 80, 90, 100, 90, 80, 70, 60, 60 };
        System.out.println(candy.candy(ratings));
    }

}
