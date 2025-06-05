package org.abhishek.heap;

import java.util.*;


class PairSum {

    int x;
    int y;
    int sum;

    public PairSum(int x, int y, int sum) {
        this.x = x;
        this.y = y;
        this.sum = sum;
    }
}

public class KPairsWithSmallestSum {


    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> answer = new ArrayList<>();

        PriorityQueue<PairSum> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.sum));
        pq.add(new PairSum(0, 0, nums1[0] + nums2[0]));

        Set<List<Integer>> visited = new HashSet<>();
        visited.add(List.of(0, 0));

        while (k > 0 && !pq.isEmpty()) {
            PairSum pair = pq.poll();

            int x = pair.x;
            int y = pair.y;

            answer.add(List.of(nums1[x], nums2[y]));
            if (x < nums1.length - 1) {
                if (!visited.contains(List.of(x + 1, y))) {
                    visited.add(List.of(x + 1, y));
                    pq.add(new PairSum(x + 1, y, nums1[x + 1] + nums2[y]));
                }
            }
            if (y < nums2.length - 1) {
                if (!visited.contains(List.of(x, y + 1))) {
                    visited.add(List.of(x, y + 1));
                    pq.add(new PairSum(x, y + 1, nums1[x] + nums2[y + 1]));
                }

            }
            k--;
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums1 = {-5, 1, 2, 3};
        int[] nums2 = {-5, -4, 3, 5};

        System.out.println(kSmallestPairs(nums1, nums2, 10));

    }
}
