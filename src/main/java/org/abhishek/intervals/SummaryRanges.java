package org.abhishek.intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {
        List<String> answer = new ArrayList<>();
        for(int i = 0 ; i< nums.length ;i++) {
            int start = nums[i];
            int end = nums[i];

            while (i< nums.length-1 && (end + 1 == nums[i+1])){
                end = nums[i+1];
                i++;
            }
            if(start==end) {
                answer.add(String.valueOf(start));
            } else {
                answer.add(start + "->" + end);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6,8,9};
        System.out.println(summaryRanges(nums));
    }
}
