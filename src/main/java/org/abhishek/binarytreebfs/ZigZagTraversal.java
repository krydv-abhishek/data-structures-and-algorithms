package org.abhishek.binarytreebfs;

import java.util.*;

public class ZigZagTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> levelNodes = new LinkedList<>();
            while (size>0) {
                TreeNode node = queue.poll();

                if(leftToRight) {
                    levelNodes.addLast(node.val);
                } else {
                    levelNodes.addFirst(node.val);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }

            leftToRight = !leftToRight;
            answer.add(levelNodes);

        }
        return answer;

    }

    public static void main(String[] args) {

        Integer[] elements = {1, 2, 3, 4, 5, 6, 7};
        //Integer[] elements = {2147483647,2147483647,2147483647};
        TreeNode root = TreeNode.buildTreeLevelWise(elements);

        TreeNode.printTree(root);

        System.out.println(zigzagLevelOrder(root));

    }
}
