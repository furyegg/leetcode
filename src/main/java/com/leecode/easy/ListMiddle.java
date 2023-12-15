package com.leecode.easy;

public class ListMiddle {
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

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static void print(ListNode list) {
        ListNode l = list;
        while (l != null) {
            System.out.print(l.val);
            l = l.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListMiddle app = new ListMiddle();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        print(l1);
        ListNode r1 = app.middleNode(l1);
        print(r1);

        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        print(l2);
        ListNode r2 = app.middleNode(l2);
        print(r2);
    }
}