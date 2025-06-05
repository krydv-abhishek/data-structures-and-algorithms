package org.abhishek.bst;

import java.util.Stack;

public class KthSmallest {


    public static int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();
        int index = 0;

        TreeNode itr = root;

        while(itr!=null || !stack.isEmpty()) {
            while(itr!=null) {
                stack.add(itr);
                itr = itr.left;
            }

            index++;
            itr = stack.pop();
            if(index == k) {
                return itr.val;
            }

            itr = itr.right;

        }
        return -1;

    }



    public static void main(String[] args) {

        Integer[] elements = {5,3,6,2,4,null,null,1};
        //Integer[] elements = {2147483647,2147483647,2147483647};
        TreeNode root = TreeNode.buildTreeLevelWise(elements);

        TreeNode.printTree(root);

        System.out.println(kthSmallest(root, 4));

    }
}
