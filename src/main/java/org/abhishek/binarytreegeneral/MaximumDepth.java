package org.abhishek.binarytreegeneral;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepth {

    public static int maxDepth(TreeNode root) {

        int max = -1;
        int d = 0;
        return findDepth(root,max, d);
    }

    public static int findDepth(TreeNode root, int max, int d) {
        if(root == null) {
            return Math.max(max, d);
        }
        d++;
        return Math.max(findDepth(root.left, max, d), findDepth(root.right, max, d));

    }

    public static void main(String[] args) {

        TreeNode root = null;
        int[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int value : elements) {
            root = insert(root, value);
        }
        System.out.println(maxDepth(root));

    }

    public static TreeNode insert(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Insert in left child if empty
            if (current.left == null) {
                current.left = new TreeNode(value);
                break;
            } else {
                queue.add(current.left);
            }

            // Insert in right child if empty
            if (current.right == null) {
                current.right = new TreeNode(value);
                break;
            } else {
                queue.add(current.right);
            }
        }
        return root;
    }
}
