package org.abhishek.linkedlist;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode answerHead = head;

        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = (l1.val + l2.val) + carry;
            head.val = sum % 10;
            if (l1.next != null || l2.next != null) {
                ListNode newHead = new ListNode(0);
                head.next = newHead;
                head = newHead;
            }
            carry = sum / 10;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            head.val = sum % 10;

            if (l1.next != null) {
                ListNode newHead = new ListNode(0);
                head.next = newHead;
                head = newHead;
            }

            carry = sum / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            head.val = sum % 10;
            if (l2.next != null) {
                ListNode newHead = new ListNode(0);
                head.next = newHead;
                head = newHead;
            }
            carry = sum / 10;
            l2 = l2.next;
        }

        if(carry!=0) {
            head.next = new ListNode(carry);
        }

        return answerHead;
    }

    public static void main(String[] args) {

        ListNode num1 = new ListNode(9);
        ListNode num2 = new ListNode(2);
        ListNode num3 = new ListNode(3);
        ListNode num4 = new ListNode(4);

        num1.next = num2;
        num2.next = num3;


        System.out.println(addTwoNumbers(num4, num1));

    }
}
