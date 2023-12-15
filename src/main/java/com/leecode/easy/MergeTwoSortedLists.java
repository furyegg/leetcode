package com.leecode.easy;

public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
        }
        
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        
        public void print() {
            StringBuilder sb = new StringBuilder();
            sb.append(val);
            ListNode nextNode = next;
            while (nextNode != null) {
                sb.append(nextNode.val);
                nextNode = nextNode.next;
            }
            System.out.println(sb);
        }
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (head != null) {
            if (l1 == null || l2 == null) {
                break;
            }
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            } else {
                head.next = l2;
                l2 = l2.next;
                head = head.next;
            }
        }
        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        MergeTwoSortedLists app = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        app.mergeTwoLists(l1, l2).print();
        System.out.println(System.currentTimeMillis() - start);
    }
}