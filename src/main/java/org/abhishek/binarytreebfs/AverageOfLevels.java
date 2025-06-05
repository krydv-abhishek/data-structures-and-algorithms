package org.abhishek.binarytreebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {

    public static List<Double> rightSideView(TreeNode root) {

        if (root == null) {
            return null;
        }
        List<Double> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            double avg = 0.0;
            int i =0;
            while (i< size) {
                TreeNode node = queue.poll();
                avg = avg + node.val;
                if (node.right != null) queue.add(node.right);
                if (node.left != null) queue.add(node.left);
                i++;
            }
            answer.add(((avg/size)*100000)/100000);

        }
        return answer;

    }

    public static void main(String[] args) {

        //Integer[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Integer[] elements = {2147483647,2147483647,2147483647};
        TreeNode root = TreeNode.buildTreeLevelWise(elements);

        TreeNode.printTree(root);

        System.out.println(rightSideView(root));

    }
}
