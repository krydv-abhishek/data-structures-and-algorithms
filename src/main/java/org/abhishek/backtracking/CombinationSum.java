package org.abhishek.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> answer = new ArrayList<>();
        backtrack(0, answer, candidates, new ArrayList<>(), 0, target);
        return answer;

    }


    public static void backtrack(int index,
                                 List<List<Integer>> answer, int[] n, List<Integer> currList, int sum, int target) {

        if(sum==target) {
            answer.add(new ArrayList<>(currList));
            return;
        }

        if(sum>target) {
            return;
        }

        for(int i=index; i<n.length; i++) {
            currList.add(n[i]);
            sum = sum + n[i];
            backtrack(i, answer, n, currList, sum, target);
            currList.remove(currList.size() - 1);
            sum = sum - n[i];
        }

    }

    public static void main(String[] args) {
        int[] nums = {2,3,5};
        System.out.println(combinationSum(nums, 8));
    }
}
