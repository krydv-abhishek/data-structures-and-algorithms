package org.abhishek.linkedlist;

public class DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode iterator = head;
        ListNode answerHead = null;
        ListNode answerHeadIterator = null;
        int flag = 0;

        while (iterator != null) {
            flag = 0;

            while (iterator.next != null && iterator.val == iterator.next.val) {
                iterator = iterator.next;
                flag = 1;
            }
            if (flag == 0) {
                if (answerHead == null) {
                    answerHead = new ListNode(iterator.val);
                    answerHeadIterator = answerHead;
                } else {
                    ListNode newNode = new ListNode(iterator.val);
                    answerHeadIterator.next = newNode;
                    answerHeadIterator = newNode;
                }
            }
            iterator = iterator.next;
        }
        return answerHead;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(3);

        ListNode head = deleteDuplicates(node);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
