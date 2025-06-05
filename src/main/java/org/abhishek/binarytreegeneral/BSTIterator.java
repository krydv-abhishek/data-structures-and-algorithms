package org.abhishek.binarytreegeneral;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTIterator {

    private TreeNode nextItr = null;
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {

        TreeNode itr = root;

        while (itr.left != null) {
            stack.push(itr);
            itr = itr.left;
        }
        nextItr = itr;
    }

    public int next() {

        int val = nextItr.val;
        TreeNode itr = nextItr.right;
        if (itr == null) {
            if (!stack.isEmpty()) {
                nextItr = stack.pop();
            } else {
                nextItr = null;
            }
            return val;
        }
        while (itr.left != null) {
            stack.push(itr);
            itr = itr.left;
        }
        nextItr = itr;

        return val;
    }

    public boolean hasNext() {
        return nextItr != null;
    }

    public static void main(String[] args) {

        Integer[] elements = {7, 3, 15, null, null, 9, 20};
        TreeNode root = TreeNode.buildTreeLevelWise(elements);

        TreeNode.printTree(root);

        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());

        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());

        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());

    }

    public static TreeNode insert(TreeNode root, Integer value) {
        if (root == null) return new TreeNode(value);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Insert in left child if empty
            if (current.left == null) {
                if (value != null) {
                    current.left = new TreeNode(value);
                }
                break;
            } else {
                queue.add(current.left);
            }

            // Insert in right child if empty
            if (current.right == null) {
                if (value != null) {
                    current.right = new TreeNode(value);
                }
                break;
            } else {
                queue.add(current.right);
            }
        }
        return root;
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
