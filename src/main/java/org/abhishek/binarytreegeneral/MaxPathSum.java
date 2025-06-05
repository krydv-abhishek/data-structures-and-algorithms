package org.abhishek.binarytreegeneral;

public class MaxPathSum {

    private   static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {

        helper(root);
        return maxSum;
    }

    private static int helper(TreeNode root) {

        if(root==null) {
            return 0;
        }

        int leftSum = Math.max(0, helper(root.left));
        int rightSum = Math.max(0, helper(root.right));

        maxSum = Math.max(maxSum, leftSum + rightSum + root.val);

        return root.val + Math.max(leftSum, rightSum);

    }


    public static void main(String[] args) {

        Integer[] elements = {1, 2, 3};
        TreeNode root = TreeNode.buildTreeLevelWise(elements);

        TreeNode.printTree(root);

        System.out.println(maxPathSum(root));

    }
}
