package org.abhishek.linkedlist;

public class ReverseNodeInKGroup {

    public static void reverseBetween(ListNode startNode, ListNode endNode) {

        ListNode nextNode = endNode.next;
        ListNode itr = startNode;

        while(itr!=endNode) {
            ListNode next = itr.next;
            itr.next = nextNode;
            nextNode = itr;
            itr = next;
        }
        itr.next = nextNode;

    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        if(k==1) {
            return head;
        }

        ListNode itr = head;
        ListNode startNode = head;
        ListNode endNode;
        ListNode newHead = null;
        ListNode newItr = null;
        int i =1;

        while(itr!=null) {
            endNode = itr;
            if(i==k) {
                i = 1;
                reverseBetween(startNode, endNode);
                if(newHead==null) {
                    newHead = endNode;
                } else {
                    newItr.next = endNode;
                }
                newItr = startNode;
                itr = startNode.next;
                startNode = itr;
                continue;
            }
            itr = itr.next;
            i++;
        }

        if(startNode!=null){
            newItr.next = startNode;
        }
        return newHead;
    }

    public static void main(String[] args) {

        int[] list = {2,3,4,5,6,7,8};
        ListNode node = new ListNode(1);
        ListNode mainHead = node;
        for(int n: list){
            node.next = new ListNode(n);
            node = node.next;
        }


        ListNode head = reverseKGroup(mainHead, 3);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

}
