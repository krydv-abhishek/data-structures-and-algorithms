package org.abhishek.binarytreegeneral;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {

    public static TreeNode invertTree(TreeNode root) {

        if(root == null) {
            return null;
        } else  {
            TreeNode leftRoot = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(leftRoot);
        }
        return root;

    }


    public static void main(String[] args) {

        TreeNode root = null;
        int[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int value : elements) {
            root = insert(root, value);
        }

        levelOrder(invertTree(root));

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

}
