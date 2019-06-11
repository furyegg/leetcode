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
            System.out.println(sb.toString());
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
    
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        ListNode l;
        ListNode node;
        ListNode n1;
        ListNode n2;
        
        if (l1.val == l2.val) {
            l = l1;
            n1 = l1.next;
            l.next = l2;
            node = l2;
            n2 = l2.next;
        } else {
            l = l1.val < l2.val ? l1 : l2;
            node = l;
            n1 = l1.val < l2.val ? l1.next : l1;
            n2 = l1.val < l2.val ? l2 : l2.next;
        }
        
        while (n1 != null && n2 != null) {
            if (n1.val == n2.val) {
                ListNode n1Next = n1.next;
                node.next = n1;
                n1.next = n2;
                node = n2;
                n1 = n1Next;
                n2 = n2.next;
            } else if (n1.val < n2.val) {
                node.next = n1;
                n1 = n1.next;
            } else {
                node.next = n2;
                n2 = n2.next;
            }
            node = node.next;
        }
        
        if (n1 != null) {
            node.next = n1;
        }
        if (n2 != null) {
            node.next = n2;
        }
        
        return l;
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