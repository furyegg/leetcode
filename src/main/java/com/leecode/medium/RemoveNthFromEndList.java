package com.leecode.medium;

import com.leecode.easy.ListMiddle;

public class RemoveNthFromEndList {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; ++i) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            ++count;
            node = node.next;
        }

        int position = count - n;
        if (position == 0) {
            return head.next;
        }

        node = head;
        for (int i = 0; i < position - 1; ++i) {
            node = node.next;
        }
        if (node.next.next == null) {
            node.next = null;
        } else {
            node.next = node.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveNthFromEndList app = new RemoveNthFromEndList();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        print(l1);
        ListNode r1 = app.removeNthFromEnd(l1, 2);
        print(r1);

        ListNode l2 = new ListNode(1);
        print(l2);
        ListNode r2 = app.removeNthFromEnd(l2, 1);
        print(r2);

        ListNode l3 = new ListNode(1, new ListNode(2));
        print(l3);
        ListNode r3 = app.removeNthFromEnd(l3, 1);
        print(r3);

        ListNode l4 = new ListNode(1, new ListNode(2));
        print(l4);
        ListNode r4 = app.removeNthFromEnd(l4, 2);
        print(r4);
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