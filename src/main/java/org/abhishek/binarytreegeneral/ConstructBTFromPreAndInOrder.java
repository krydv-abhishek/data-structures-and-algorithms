package org.abhishek.binarytreegeneral;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ConstructBTFromPreAndInOrder {
    private static Map<Integer, Integer> indexMap;
    private static int preOrderIndex = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        indexMap = new HashMap<>();
        for(int i =0 ;i< inorder.length ;i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, inorder.length - 1);

    }

    public static TreeNode buildTreeHelper(int[] preorder, int start, int end) {

        if (start > end) return null;

        int nodeVal = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(nodeVal);
        int indexInInorder = indexMap.get(nodeVal);

        root.left = buildTreeHelper(preorder, start, indexInInorder-1);
        root.right = buildTreeHelper(preorder, indexInInorder + 1, end);

        return root;
    }



    public static void main(String[] args) {

//        int[] inorder = {1, 2, 4, 5, 9, 3, 6, 7, 8};
//        int[] preorder = {4, 2, 9, 5, 1, 6, 3, 8, 7};
        int[] inorder = {-1};
        int[] preorder = {-1};

        levelOrder(buildTree(inorder, preorder));


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
