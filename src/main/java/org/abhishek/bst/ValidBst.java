package org.abhishek.bst;

import java.util.Stack;

public class ValidBst {

    public static boolean isValidBST(TreeNode root) {


        Stack<TreeNode> stack = new Stack<>();
        long lastVal = (long)Integer.MAX_VALUE + 1;

        TreeNode itr = root;

        while(itr!=null || !stack.isEmpty()) {
            while(itr!=null) {
                stack.add(itr);
                itr = itr.left;
            }

            itr = stack.pop();
            if(lastVal != (long)Integer.MAX_VALUE + 1 && lastVal >= itr.val) {
                return false;
            }
            lastVal = itr.val;

            itr = itr.right;

        }
        return true;
    }




    public static void main(String[] args) {

        Integer[] elements = {5, 3, 6, 2, 4, null, null, 1};
        //Integer[] elements = {2147483647,2147483647,2147483647};
        TreeNode root = TreeNode.buildTreeLevelWise(elements);

        TreeNode.printTree(root);

        System.out.println(isValidBST(root));

    }
}
