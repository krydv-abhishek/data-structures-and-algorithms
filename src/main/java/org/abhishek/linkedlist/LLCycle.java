package org.abhishek.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LLCycle {

    public static boolean hasCycle(ListNode head) {

        Set<ListNode> visited = new HashSet<>();

        while (head != null && !visited.contains(head)) {
            visited.add(head);
            head = head.next;
        }

        return head != null;
    }

    public static void main(String[] args) {

        ListNode num1 = new ListNode(3);
        ListNode num2 = new ListNode(2);
        ListNode num3 = new ListNode(0);
        ListNode num4 = new ListNode(-4);

        num1.next = num2;
        num2.next = num3;
        num3.next = num4;
        num4.next = num2;

        System.out.println(hasCycle(num1));

    }
}
