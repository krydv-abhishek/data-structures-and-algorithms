package org.abhishek.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> permute(int[] n) {

        List<List<Integer>> answer = new ArrayList<>();
        backtrack(0, answer, n);
        return answer;

    }


    public static void backtrack(int index,
                                 List<List<Integer>> answer, int[] n) {

        if(index==n.length) {
            answer.add(arrayToList(n));
            return;
        }

        for(int i=index; i<n.length; i++) {
            swap(index, i, n);
            backtrack(index+1, answer, n);
            swap(index, i, n);
        }

    }

    public static void swap(int i, int j, int[] list) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
    private static List<Integer> arrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
}
