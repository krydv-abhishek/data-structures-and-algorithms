package org.abhishek.divideandconquer;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class SortList {

    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode otherHalf = divide(head);

        ListNode sortedFirstHalf = sortList(head);
        ListNode sortedSecondHalf = sortList(otherHalf);

        return mergeBothHalf(sortedFirstHalf, sortedSecondHalf);

    }

    private static ListNode mergeBothHalf(ListNode sortedFirstHalf, ListNode sortedSecondHalf) {
        if(sortedFirstHalf==null) {
            return sortedSecondHalf;
        }
        if(sortedSecondHalf==null) {
            return sortedFirstHalf;
        }
        if(sortedFirstHalf.val < sortedSecondHalf.val) {

            sortedFirstHalf.next = mergeBothHalf(sortedFirstHalf.next, sortedSecondHalf);
            return sortedFirstHalf;
        } else {
            sortedSecondHalf.next = mergeBothHalf(sortedFirstHalf, sortedSecondHalf.next);
            return sortedSecondHalf;
        }

    }

    public static ListNode divide(ListNode head) {
        ListNode itrSlow = head;
        ListNode itrFast = head;

        while (itrFast != null && itrFast.next != null) {
            itrFast = itrFast.next.next;
            if (itrFast != null) {
                itrSlow = itrSlow.next;

            }
        }
        ListNode temp = itrSlow.next;
        itrSlow.next = null;
        return temp;
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(3);
        listNode1.next = new ListNode(5);
        listNode1.next.next = new ListNode(1);
        listNode1.next.next.next = new ListNode(-1);

        ListNode mergedHead = sortList(listNode1);

        while (mergedHead!=null) {
            System.out.print(mergedHead.val + " ");
            mergedHead = mergedHead.next;
        }

    }
}
