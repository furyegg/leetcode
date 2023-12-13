package com.leecode.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    private void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(Node node) {
        Node tmp = head.next;
        head.next = node;
        node.pre = head;
        node.next = tmp;
        tmp.pre = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node valueNode = map.get(key);
        deleteNode(valueNode);
        addToHead(valueNode);
        return valueNode.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node valueNode = map.get(key);
            valueNode.value = value;
            deleteNode(valueNode);
            addToHead(valueNode);
            map.put(key, valueNode);
        } else {
            Node newNode = new Node(key, value);
            addToHead(newNode);
            if (map.size() == capacity) {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
            }
            map.put(key, newNode);
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
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