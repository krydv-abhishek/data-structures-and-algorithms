package org.abhishek.binarytreegeneral;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointer {

    public static Node connect(Node root) {

        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node head = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                System.out.print(current.val + " ");
                if (head == null) {
                    head = current;
                } else {
                    head.next = current;
                    head = head.next;
                }

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            head.next = null;
            head = null;
        }

        return root;

    }

    public static void main(String[] args) {

        Node root = null;
        int[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int value : elements) {
            root = insert(root, value);
        }

        levelOrder(connect(root));

    }


    public static Node insert(Node root, int value) {
        if (root == null) return new Node(value);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // Insert in left child if empty
            if (current.left == null) {
                current.left = new Node(value);
                break;
            } else {
                queue.add(current.left);
            }

            // Insert in right child if empty
            if (current.right == null) {
                current.right = new Node(value);
                break;
            } else {
                queue.add(current.right);
            }
        }
        return root;
    }

    public static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.next != null) {
                System.out.println(current.val + "->" + current.next.val);
            } else {
                System.out.println(current.val + "-> null");
            }

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

}
