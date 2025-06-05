package org.abhishek.linkedlist;

public class PartitionList {

    public static ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode itr = head;

        ListNode smallerElementsHeadNode = new ListNode(0);
        ListNode itrSmallerElements = smallerElementsHeadNode;

        ListNode largerElementsHeadNode = new ListNode(0);
        ListNode itrLargerElements = largerElementsHeadNode;

        while(itr!=null) {
            if(itr.val < x) {
                itrSmallerElements.next = new ListNode(itr.val);
                itrSmallerElements = itrSmallerElements.next;
            } else {
                itrLargerElements.next = new ListNode(itr.val);
                itrLargerElements = itrLargerElements.next;
            }
            itr = itr.next;
        }
        largerElementsHeadNode = largerElementsHeadNode.next;

        itrSmallerElements.next = largerElementsHeadNode;
        return smallerElementsHeadNode.next;

    }

    public static void main(String[] args) {

        int[] list = {4,3,0,2,5,2};
        ListNode node = new ListNode(1);
        ListNode mainHead = node;
        for(int n: list){
            node.next = new ListNode(n);
            node = node.next;
        }


        ListNode head = partition(mainHead, 3);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}
