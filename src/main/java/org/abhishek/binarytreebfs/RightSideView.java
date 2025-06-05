package org.abhishek.binarytreebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

//Recursive
/*    void solve(TreeNode root, List<Integer> ans, int level){
        if(root==null){
            return;
        }
        if(level==ans.size()){
            ans.add(root.val);
        }
        solve(root.right,ans,level+1);
        solve(root.left,ans,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        solve(root,ans,0);
        return ans;
    }*/

    public static List<Integer> rightSideView(TreeNode root) {

        if (root == null) {
            return null;
        }
        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            TreeNode rightNode = queue.peek();
            answer.add(rightNode.val);
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.right != null) queue.add(node.right);
                if (node.left != null) queue.add(node.left);
                size--;
            }

        }
        return answer;

    }

    public static void main(String[] args) {

        Integer[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        TreeNode root = TreeNode.buildTreeLevelWise(elements);

        TreeNode.printTree(root);

        System.out.println(rightSideView(root));

    }
}
