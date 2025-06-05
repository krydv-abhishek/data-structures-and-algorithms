package org.abhishek.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104

Intuition :
First thought of linear placement of intervals, but it was n+k. k being difference in range values.
Later sorted through first element of interval and overlapped.
 */
public class MergeIntervals {
    public static int[][] mergeEffective(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int k = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[k][1] >= intervals[i][0]) {
                intervals[k][1] = Math.max(intervals[k][1], intervals[i][1]);
            } else {
                k++;
                intervals[k] = intervals[i];
            }
        }
        return Arrays.copyOfRange(intervals, 0, k + 1);
    }

    public static int[][] merge(int[][] intervals) {
        List<List<Integer>> answer = new ArrayList<>();

        List<List<Integer>> listOfIntervals = Arrays.stream(intervals).map(interval ->
                        Arrays.stream(interval).boxed().collect(Collectors.toList()))
                .sorted(Comparator.comparing(interval -> interval.get(0))).collect(Collectors.toList());

        int maxStart = listOfIntervals.get(0).get(0);
        int maxEnd = listOfIntervals.get(0).get(1);
        for (int i = 1; i < listOfIntervals.size(); i++) {
            List<Integer> interval = listOfIntervals.get(i);
            if (maxEnd < interval.get(0)) {
                answer.add(List.of(maxStart, maxEnd));
                maxStart = interval.get(0);
                maxEnd = interval.get(1);
            } else {
                maxEnd = Math.max(interval.get(1), maxEnd);
            }
        }
        answer.add(List.of(maxStart, maxEnd));


        int[][] result = new int[answer.size()][];
        int i = 0;
        for (List<Integer> nestedList : answer) {
            result[i] = new int[nestedList.size()];
            for (int j = 0; j < nestedList.size(); j++) {
                result[i][j] = nestedList.get(j);
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        //int[][] intervals = {{1,4},{4,5}};
        //int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        //int[][] intervals = {{1,3},{4,5},{3,5},{3,7}};
        int[][] intervals = {{1, 3}};


        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
