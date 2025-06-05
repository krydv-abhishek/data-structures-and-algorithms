package org.abhishek.linkedlist;

/*
Best solution is to use recursion

 */
public class MergeTwoList {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

//    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//
//        if(l1==null && l2==null) {
//            return null;
//        }
//
//        ListNode mergedHead = new ListNode(0);
//        ListNode head = mergedHead;
//
//        while (l1 != null && l2 != null) {
//            int val = l2.val;
//            if (l1.val <= l2.val) {
//                val = l1.val;
//                l1 = l1.next;
//            } else {
//                l2 = l2.next;
//            }
//            head.val = val;
//            head.next = new ListNode(0);
//            head = head.next;
//        }
//
//        while (l2 != null) {
//            head.val = l2.val;
//            l2 = l2.next;
//            if(l2!=null) {
//                head.next = new ListNode(0);
//                head = head.next;
//            }
//        }
//
//        while (l1 != null) {
//            head.val = l1.val;
//            l1 = l1.next;
//            if(l1!=null) {
//                head.next = new ListNode(0);
//                head = head.next;
//            }
//        }
//        return mergedHead;
//    }

    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = null;
        ListNode list4 = new ListNode(0);


        ListNode mergedListHead = mergeTwoLists(list3, list4);

        while (mergedListHead != null) {
            System.out.println(mergedListHead.val);
            mergedListHead = mergedListHead.next;
        }
    }
}
