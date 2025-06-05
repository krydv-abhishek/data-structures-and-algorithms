package org.abhishek.divideandconquer;


public class MergeKSortedList {

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }
        return mergeKListsHelper(lists, 0, lists.length-1);

    }

    public static ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {

        if(start==end) {
            return lists[start];
        }

        if(start<end){
            int mid = (end+start)/2;
            ListNode firstHalf = mergeKListsHelper(lists, start, mid);
            ListNode secondHalf = mergeKListsHelper(lists, mid+1, end);
            return mergeBothHalf(firstHalf, secondHalf);
        }
        return null;

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

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(3);
        listNode1.next = new ListNode(5);
        listNode1.next.next = new ListNode(6);
        listNode1.next.next.next = new ListNode(7);

        ListNode listNode2 = new ListNode(3);
        listNode2.next = new ListNode(8);
        listNode2.next.next = new ListNode(9);
        listNode2.next.next.next = new ListNode(10);

        ListNode listNode3 = new ListNode(3);
        listNode3.next = new ListNode(8);
        listNode3.next.next = new ListNode(9);
        listNode3.next.next.next = new ListNode(10);

        ListNode[] array = new ListNode[3];
        array[0] = listNode1;
        array[1] = listNode2;
        array[2] = listNode3;

        ListNode mergedHead = mergeKLists(array);

        while (mergedHead!=null) {
            System.out.print(mergedHead.val + " ");
            mergedHead = mergedHead.next;
        }

    }
}

