package com.leecode.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        Node(int key, int value, Node pre, Node next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

    private Map<Integer, Node> map = new HashMap<>();
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        if (capacity == 1) {
            return head.value;
        }

        Node valueNode = map.get(key);
        if (valueNode.key == head.key) {
            return valueNode.value;
        }

        toHead(valueNode);
        return valueNode.value;
    }

    private void toHead(Node valueNode) {
        if (valueNode.key == head.key) {
            return;
        }

        if (valueNode.next != null) {
            valueNode.next.pre = valueNode.pre;
        }

        if (valueNode.pre != null) {
            valueNode.pre.next = valueNode.next;
        }

        if (valueNode.key == tail.key) {
            tail = valueNode.pre;
        }

        valueNode.next = head;
        head.pre = valueNode;
        head = valueNode;
        valueNode.pre = null;
    }

    public void put(int key, int value) {
        if (head == null || capacity == 1) {
            head = new Node(key, value, null, null);
            tail = head;
            map.clear();
            map.put(key, head);
            return;
        }

        if (map.containsKey(key)) {
            Node valueNode = map.get(key);
            valueNode.value = value;
            toHead(valueNode);
            return;
        }

        Node newHead = new Node(key, value, null, head);
        head.pre = newHead;
        head = newHead;

        if (map.size() == capacity && tail.pre != null) {
            Node newTail = tail.pre;
            map.remove(tail.key);
            tail = newTail;
            tail.next = null;
        }

        map.put(key, newHead);
    }

    public static void main(String[] args) {
        test5();
    }

    private static void test1() {
        System.out.println("test1............");
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("get 1: " + cache.get(1));
        cache.put(3, 3);
        System.out.println("get 2: " + cache.get(2));
        cache.put(4, 4);
        System.out.println("get 1: " + cache.get(1));
        System.out.println("get 3: " + cache.get(3));
        System.out.println("get 4: " + cache.get(4));
    }

    private static void test2() {
        System.out.println("test2............");
        LRUCache cache = new LRUCache(1);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("get 1: " + cache.get(1));
        cache.put(3, 3);
        System.out.println("get 2: " + cache.get(2));
        cache.put(4, 4);
        System.out.println("get 1: " + cache.get(1));
        System.out.println("get 3: " + cache.get(3));
        System.out.println("get 4: " + cache.get(4));
    }

    private static void test3() {
        System.out.println("test3............");
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("get 1: " + cache.get(1));
        cache.put(3, 3);
        System.out.println("get 2: " + cache.get(2));
        cache.put(4, 4);
        System.out.println("get 1: " + cache.get(1));
        System.out.println("get 3: " + cache.get(3));
        System.out.println("get 4: " + cache.get(4));
    }

    //["LRUCache","get","put","get","put","put","get","get"]
    //[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
    private static void test4() {
        System.out.println("test4............");
        LRUCache cache = new LRUCache(2);
        System.out.println("get 2: " + cache.get(2));
        cache.put(2, 6);
        System.out.println("get 1: " + cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println("get 1: " + cache.get(1));
        System.out.println("get 1: " + cache.get(2));
    }

    //["LRUCache","put","put","get","put","put","get"]
    //[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
    private static void test5() {
        System.out.println("test5............");
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println("get 2: " + cache.get(2));
        cache.put(1, 1);
        cache.put(4, 1);
        System.out.println("get 2: " + cache.get(2));
    }
}