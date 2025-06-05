package org.abhishek.binarytreegeneral;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {

        return checkSymmetric(root, root);

    }

    public static boolean checkSymmetric(TreeNode rootLeft, TreeNode rooRight) {

        if(rootLeft==null && rooRight==null) {
            return true;
        }

        if(rootLeft==null || rooRight==null || rootLeft.val != rooRight.val) {
            return false;
        }
        return checkSymmetric(rootLeft.left, rooRight.right) && checkSymmetric(rootLeft.right, rooRight.left);
    }


    public static void main(String[] args) {

        TreeNode root = null;
        int[] elements = {1, 2, 2, 3, 4, 4, 3};

        for (int value : elements) {
            root = insert(root, value);
        }

        System.out.println(isSymmetric(root));

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
