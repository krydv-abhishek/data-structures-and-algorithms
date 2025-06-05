package org.abhishek.heap;


import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    private final PriorityQueue<Integer> minHeap;
    private final PriorityQueue<Integer> maxHeap;
    private boolean flag;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        flag = true;
    }

    public void addNum(int num) {

        if (!flag) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        flag = !flag;
    }

    public double findMedian() {

        if (!(minHeap.isEmpty() || maxHeap.isEmpty())) {
            if (minHeap.size() == maxHeap.size()) {
                return (double) (minHeap.peek() + maxHeap.peek()) / 2.0;
            } else {
                return (double) maxHeap.peek();
            }
        }
        if (!maxHeap.isEmpty()) {
            return (double) maxHeap.peek();
        }
        if (!minHeap.isEmpty()) {
            return (double) minHeap.peek();
        }
        return -1;
    }
}

public class FindMedian {
    public static void main(String[] args) {

        MedianFinder medianFinder = new MedianFinder();

        int[] nums = {5, 6, 4, 3, 2, 1};
        for (int n : nums) {
            medianFinder.addNum(n);
        }
        System.out.println(medianFinder.findMedian());
        int[] nums1 = {5, 4, 3, 2, 1};
        for (int n : nums1) {
            medianFinder.addNum(n);
        }
        System.out.println(medianFinder.findMedian());


    }
}
