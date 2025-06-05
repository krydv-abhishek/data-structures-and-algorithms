package org.abhishek.binarytreebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static  List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            int i =0;
            List<Integer> levelNodes = new ArrayList<>();
            while (i< size) {
                TreeNode node = queue.poll();
                levelNodes.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                i++;
            }
            answer.add(levelNodes);

        }
        return answer;

    }

    public static void main(String[] args) {

        Integer[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //Integer[] elements = {2147483647,2147483647,2147483647};
        TreeNode root = TreeNode.buildTreeLevelWise(elements);

        TreeNode.printTree(root);

        System.out.println(levelOrder(root));

    }
}
