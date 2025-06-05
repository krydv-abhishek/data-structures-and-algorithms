package org.abhishek.divideandconquer;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class SortedArrayToBST {

    public static TreeNode sortedArrayToBST(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        return sortedArrayToBSTHelper(nums, start, end);
    }

    public static TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int mid = (end + start) / 2;
        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.left = sortedArrayToBSTHelper(nums, start, mid - 1);
        midNode.right = sortedArrayToBSTHelper(nums, mid + 1, end);

        return midNode;
    }

    public static void levelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);

        }
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        levelOrder(sortedArrayToBST(nums));
    }
}