package org.abhishek.hashmap;

import java.util.HashSet;
import java.util.Set;
/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109

intuition - find probables starting points
 */
public class ConsecutiveSequence {


    public static int longestConsecutive(int[] nums) {

        if(nums.length==0){
            return 0;
        }

        Set<Integer> hash = new HashSet<>();
        Set<Integer> starters = new HashSet<>();
        for(int n: nums) hash.add(n);
        for(int n: nums) {
            if(!hash.contains(n-1)) {
                starters.add(n);
            }
        }
        int maxAnswer = 0;
        for (int n: starters){
            int answer =1;
            while(hash.contains(n+1)) {
                n++;
                answer ++;
            }
            if(answer >maxAnswer){
                maxAnswer = answer;
            }
        }

        return maxAnswer;

    }

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }
}
