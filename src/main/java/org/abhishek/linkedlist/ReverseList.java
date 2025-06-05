package org.abhishek.linkedlist;

public class ReverseList {

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode iterator = head;
        ListNode previous = null;
        ListNode next;
        ListNode leftNode = null;
        ListNode rightNode = null;
        ListNode firstNext = null;
        ListNode firstLeft = null;
        int n = 1;

        while (iterator != null) {
            if (n < left) {
                if (n == 1) {
                    firstLeft = iterator;
                }
                leftNode = iterator;
                iterator = iterator.next;
            } else if (n > right) {
                rightNode = iterator;
                break;
            } else {
                if (firstNext == null) {
                    firstNext = iterator;
                }
                next = iterator.next;
                iterator.next = previous;
                previous = iterator;
                iterator = next;
            }

            n++;
        }
        if (leftNode != null) {
            leftNode.next = previous;
            previous = firstLeft;
        }
        if (rightNode != null && firstNext != null) {
            firstNext.next = rightNode;
        }
        return previous;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);

        ListNode head = reverseBetween(node, 1, 1);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
