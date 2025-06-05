package org.abhishek.linkedlist;

public class RemoveNthNode {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode iterator = head;
        ListNode removeNode = null;
        int k = 0;
        int flag = 0;
        while (iterator != null) {
            k++;
            if (k >= n) {
                if (removeNode == null) {
                    removeNode = head;
                } else {
                    if (removeNode == head && flag == 0) {
                        flag = 1;
                    } else {
                        removeNode = removeNode.next;
                    }
                }
            }

            iterator = iterator.next;
        }

        if (removeNode == head && flag==0) {
            return head.next;
        }
        if (removeNode.next.next == null) {
            removeNode.next = null;
        } else {
            removeNode.next = removeNode.next.next;
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);

        ListNode head = removeNthFromEnd(node, 1);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
