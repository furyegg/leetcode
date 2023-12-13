package com.leecode.medium;

public class ReverseBetweenLinkedList {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < left - 1; ++i) {
            prev = prev.next;
        }

        ListNode current = prev.next;

        for (int i = 0; i < right - left; ++i) {
            ListNode nextNode = current.next;
            current.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        return dummy.next;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        if (head.next == null || left == right) {
            return head;
        }

        int n = 0;
        ListNode startPre = null;
        ListNode start = null;
        ListNode current = head;
        ListNode next = current.next;
        ListNode nn;
        while (next != null) {
            if (left - 2 >= 0 && n == left - 2) {
                startPre = current;
            }
            if (n == left - 1) {
                start = current;
            }
            if (n == right - 1) {
                break;
            }
            nn = next.next;
            if (start != null) {
                next.next = current;
            }
            current = next;
            next = nn;
            ++n;
        }
        if (left == 1) {
            start.next = next;
            return current;
        }
        if (next == null) {
            startPre.next = current;
            start.next = null;
            return head;
        }
        startPre.next = current;
        start.next = next;
        return head;
    }
    
    public static void main(String[] args) {
        ReverseBetweenLinkedList app = new ReverseBetweenLinkedList();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        print(l1);
        ListNode r1 = app.reverseBetween(l1, 2, 4);
        print(r1);

        ListNode l2 = new ListNode(1, new ListNode(2));
        print(l2);
        ListNode r2 = app.reverseBetween(l2, 1, 2);
        print(r2);

        ListNode l3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        print(l3);
        ListNode r3 = app.reverseBetween(l3, 2, 5);
        print(r3);

        ListNode l4 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        print(l4);
        ListNode r4 = app.reverseBetween(l4, 3, 4);
        print(r4);

        ListNode l5 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        print(l5);
        ListNode r5 = app.reverseBetween(l5, 4, 5);
        print(r5);
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