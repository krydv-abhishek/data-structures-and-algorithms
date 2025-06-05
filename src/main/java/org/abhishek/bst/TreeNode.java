package org.abhishek.bst;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

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

    public static void printTree(TreeNode root) {
        printHelper(root, "", true);
    }

    public static TreeNode buildTreeLevelWise(Integer[] values) {
        if (values.length == 0 || values[0] == null) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < values.length && values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }


    public static void printHelper(TreeNode node, String prefix, boolean isLeft) {
        if (node == null) return;

        System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.val);

        // If either child exists, continue printing
        if (node.left != null || node.right != null) {
            if (node.left != null)
                printHelper(node.left, prefix + (isLeft ? "│   " : "    "), true);
            if (node.right != null)
                printHelper(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }

}
