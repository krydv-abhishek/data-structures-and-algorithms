package org.abhishek.binarytreegeneral;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ConstructBTFromPostAndInOrder {
    private static Map<Integer, Integer> indexMap;
    private static int postOrderIndex = 0;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        indexMap = new HashMap<>();
        postOrderIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeHelper(postorder, 0, inorder.length - 1);

    }

    public static TreeNode buildTreeHelper(int[] postorder, int start, int end) {

        if (start > end) return null;

        int nodeVal = postorder[postOrderIndex--];
        TreeNode root = new TreeNode(nodeVal);
        int indexInInorder = indexMap.get(nodeVal);

        root.right = buildTreeHelper(postorder, indexInInorder + 1, end);
        root.left = buildTreeHelper(postorder, start, indexInInorder - 1);


        return root;
    }


    public static void main(String[] args) {

        int[] inorder = {4, 2, 9, 5, 1, 6, 3, 8, 7};
        int[] postorder = {4, 9, 5, 2, 6, 8, 7, 3, 1};


        levelOrder(buildTree(inorder, postorder));


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
