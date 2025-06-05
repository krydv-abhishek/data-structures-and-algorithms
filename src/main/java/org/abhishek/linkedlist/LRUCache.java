package org.abhishek.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {


    class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }

    }

    Integer capacity = 0;
    ListNode lruListTail;
    ListNode lruListHead;


    Map<Integer, Integer> hash = new HashMap<>();
    Map<Integer, ListNode> linkedListHashMap = new HashMap<>();


    public LRUCache(int capacity) {
        this.capacity = capacity;
        lruListTail = new ListNode(0);
        lruListHead = lruListTail;
    }

    public int get(int key) {
        if (hash.containsKey(key)) {
            moveFront(key);
            return hash.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (hash.containsKey(key)) {
            hash.put(key, value);
            moveFront(key);
            return;
        }

        if (hash.size() >= capacity) {
            hash.remove(lruListTail.val);
            linkedListHashMap.remove(lruListTail.val);
            lruListTail.prev.next = null;
            lruListTail = lruListTail.prev;
        }

        ListNode newNode = new ListNode(key);
        addFirst(newNode);
        hash.put(key, value);
        linkedListHashMap.put(key, newNode);

    }

    public void addFirst(ListNode newNode) {

        if (lruListHead == lruListTail) {
            lruListTail = newNode;
            lruListTail.prev = lruListHead;
            lruListTail.next = null;
            lruListHead.next = lruListTail;
        } else {
            ListNode currentHead = lruListHead.next;
            lruListHead.next = newNode;
            newNode.next = currentHead;
            newNode.prev = lruListHead;
            currentHead.prev = newNode;
        }

    }

    public void moveFront(int key) {
        ListNode nodeToMove = linkedListHashMap.get(key);
        ListNode prevNode = nodeToMove.prev;

        if (prevNode != lruListHead) {
            prevNode.next = nodeToMove.next;
            if (nodeToMove.next != null) {
                nodeToMove.next.prev = prevNode;
            } else {
                lruListTail = prevNode;
            }
            ListNode currentHead = lruListHead.next;
            lruListHead.next = nodeToMove;
            nodeToMove.next = currentHead;
            nodeToMove.prev = lruListHead;
            currentHead.prev = nodeToMove;

        }
    }

    public static void main(String[] args) {

//        LRUCache lruCache = new LRUCache(2);
//        lruCache.put(1, 1);
//        System.out.println(lruCache.lruListHead.next.val);
//        lruCache.put(2, 2);
//        System.out.println(lruCache.lruListHead.next.val);
//
//        System.out.println(lruCache.get(1));
//        lruCache.put(3, 3);
//        System.out.println(lruCache.lruListHead.next.val);
//
//        System.out.println(lruCache.get(2));
//
//        lruCache.put(4, 4);
//        System.out.println(lruCache.lruListHead.next.val);
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(3));
//        System.out.println(lruCache.get(4));

        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2, 1);
        System.out.println(lruCache.lruListHead.next.val);
        //System.out.println(lruCache.get(2));
        lruCache.put(3, 2);
        System.out.println(lruCache.lruListHead.next.val);
        //System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
    }
}
