package org.abhishek.bst;

public class MinimumDifference {

    private static int minDifference = Integer.MAX_VALUE;
    private static int lastValue = Integer.MAX_VALUE;

    public static int getMinimumDifference(TreeNode root) {

        inorder(root);
        return minDifference;


    }

    public static void inorder(TreeNode root) {

        if (root == null) {
            return;
        }
        inorder(root.left);
        if (lastValue != Integer.MAX_VALUE) {
            minDifference = Math.min(minDifference, Math.abs(root.val - lastValue));
        }
        lastValue = root.val;
        inorder(root.right);

    }


    public static void main(String[] args) {

        Integer[] elements = {4, 2, 6, 1, 3};
        //Integer[] elements = {2147483647,2147483647,2147483647};
        TreeNode root = TreeNode.buildTreeLevelWise(elements);

        TreeNode.printTree(root);

        System.out.println(getMinimumDifference(root));

    }
}
