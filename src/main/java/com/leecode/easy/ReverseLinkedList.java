package com.leecode.easy;

public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode() {
        }
        
        ListNode(int val) {
            this.val = val;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        
        ListNode next = reverseList(head.next);
        next.next = head;
        head.next = null;
        return reverse(head, head.next);
    }
    
    private ListNode reverse(ListNode current, ListNode next) {
        if (next == null) {
            return current;
        } else {
            return new ListNode(next.val, current);
        }
    }
    
    public static void main(String[] args) {
        ReverseLinkedList app = new ReverseLinkedList();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
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