package org.abhishek.linkedlist;

public class RotateLeft {

    public static ListNode rotateRight(ListNode head, int k) {

        ListNode itr = head;
        ListNode last = head;
        int n = 0;
        while (itr != null) {
            if (itr.next == null) {
                last = itr;
            }
            itr = itr.next;
            n++;
        }
        k = k % n;

        itr = head;
        for (int i = 0; i < n - k-1; i++) {
            itr = itr.next;
        }
        last.next = head;
        head = itr.next;
        itr.next = null;
        return head;

    }


    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        // 0 1 2 3 4
        // 2 3 4 0 1
        ListNode head = rotateRight(node, 3);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
