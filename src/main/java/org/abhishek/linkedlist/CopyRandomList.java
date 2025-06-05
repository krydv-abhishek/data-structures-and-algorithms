package org.abhishek.linkedlist;

/**
 * 3 steps:
 * Duplicate nodes
 * Add random links
 * Restore original links
 */
public class CopyRandomList {

    public static Node copyRandomList(Node head) {


        if (head == null) {
            return null;
        }
        Node headNode = head;

        while (head != null) {
            Node nextNode = head.next;

            Node newNode = new Node(head.val);
            head.next = newNode;

            newNode.next = nextNode;

            head = nextNode;
        }

        head = headNode;

        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }

        head = headNode;

        Node pseudoHead = new Node(0);

        Node headOfCopiedNode = pseudoHead;
        Node copyItr = pseudoHead;

        while(head!=null) {
            Node nextNode = head.next.next;


            headOfCopiedNode = head.next;
            copyItr.next = headOfCopiedNode;
            copyItr = headOfCopiedNode;

            head.next = nextNode;
            head = nextNode;

        }

        return pseudoHead.next;


    }

    public static void main(String[] args) {
        Node head = new Node(3);
//        head.next = new Node(3);
//        head.next.random = head;
//        head.next.next = new Node(3);

//        while (head != null) {
//            System.out.println(head.val);
//            if (head.random != null) {
//                System.out.println(head.random.val);
//            }
//            head = head.next;
//        }

        Node copiedNode = copyRandomList(head);

        while (copiedNode != null) {
            System.out.println(copiedNode.val);
            if (copiedNode.random != null) {
                System.out.println(copiedNode.random.val);
            }
            copiedNode = copiedNode.next;
        }

    }
}
