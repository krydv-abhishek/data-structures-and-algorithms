package org.abhishek.heap;

import java.util.*;

public class KthLargest {

    public static int findKthLargestUsingPq(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<k;i++) {
            pq.add(nums[i]);
        }

        for(int i=k;i<nums.length;i++) {
            if(nums[i]>pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();

    }

    //better o(n) + klog(n)
    public static int findKthLargest(int[] nums, int k) {

        int[] currentPosition = new int[1];
        currentPosition[0] = nums.length;
        for (int i = currentPosition[0] / 2 - 1; i >= 0; i--) {
            heapify(nums, i, currentPosition[0]);
        }
        int top = extractMax(nums, currentPosition);
        while (k > 1) {
            top = extractMax(nums, currentPosition);
            k--;
        }
        return top;
    }

    public static void heapify(int[] nums, int key, int currentPosition) {
        int left = 2 * key + 1;
        int right = 2 * key + 2;

        int largest = key;

        if (left < currentPosition && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < currentPosition && nums[right] > nums[largest]) {
            largest = right;
        }

        if (largest != key) {
            int temp = nums[largest];
            nums[largest] = nums[key];
            nums[key] = temp;
            heapify(nums, largest, currentPosition);
        }

    }

    public static int extractMax(int nums[], int[] currentPosition) {

        if (currentPosition[0] == 1) {
            return nums[0];
        }

        int root = nums[0];

        nums[0] = nums[currentPosition[0] - 1];
        currentPosition[0]--;
        heapify(nums, 0, currentPosition[0]);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums, 4));

    }
}
