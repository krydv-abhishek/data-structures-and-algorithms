package org.abhishek.intervals;

import java.util.*;

/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.



Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].


Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105

Intuition :
1) Find lower bound where to insert
2) Overlap
3) Add before lower bound, newInterval and after overlap array in resultant array
 */
public class InsertIntervals {


    public static int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            int[][] answer = new int[1][2];
            answer[0] = newInterval;
            return answer;
        }
        int[][] result = null;

        int[] startOfIntervals = Arrays.stream(intervals).mapToInt(interval -> interval[0]).toArray();
        int lowerBound = Arrays.binarySearch(startOfIntervals, newInterval[0]);

        if(lowerBound<0) {
            lowerBound = -lowerBound-1;
        }
        int upperInterval = newInterval[1];

        if(lowerBound>=1 && newInterval[0]<=intervals[lowerBound-1][1]) {
            lowerBound = lowerBound-1;
            newInterval[0] = intervals[lowerBound][0];
        }

        int k = lowerBound;
        while(k<intervals.length && newInterval[1]>=intervals[k][0] ) {
            upperInterval = Math.max(intervals[k][1], newInterval[1]);
            k++;
        }

        int sizeOfResultArray = intervals.length-k+lowerBound+1;
        result = new int[sizeOfResultArray][2];

        System.arraycopy(intervals, 0, result, 0, lowerBound);
        result[lowerBound]=new int[2];
        result[lowerBound][0] = newInterval[0];
        result[lowerBound][1] = upperInterval;

        System.arraycopy(intervals, k, result, lowerBound+1, intervals.length-k);
        return result;
    }


    public static void main(String[] args) {
        //int[][] intervals = {{1,4},{4,5}};
        int[][] intervals = {{2,3},{4,5},{6,7},{8,10},{12,16}};
        //int[][] intervals = {{1,2}};

        int[] interval = {16,18};


        System.out.println(Arrays.deepToString(insert(intervals, interval)));
    }
}
