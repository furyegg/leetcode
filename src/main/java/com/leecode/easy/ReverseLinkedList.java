package com.leecode.easy;

public class ReverseLinkedList {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        
        ListNode(int val) {
            this.val = val;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
    
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode next = head.next;
        ListNode nn;
        while (next != null) {
            nn = next.next;
            next.next = current;
            current = next;
            next = nn;
        }
        head.next = null;
        return current;
    }
    
    public static void main(String[] args) {
        ReverseLinkedList app = new ReverseLinkedList();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        print(l1);
        ListNode reversed = app.reverseList(l1);
        print(reversed);
    }
    
    private static void print(ListNode list) {
        ListNode l = list;
        while (l != null) {
            System.out.print(l.val);
            l = l.next;
        }
        System.out.println();
    }
}