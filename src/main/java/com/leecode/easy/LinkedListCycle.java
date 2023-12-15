package com.leecode.easy;

public class LinkedListCycle {
    private static class ListNode {
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

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedListCycle app = new LinkedListCycle();
        test1(app);
        test2(app);
        test3(app);
        test4(app);
        test5(app);
        test6(app);
    }

    private static void test1(LinkedListCycle app) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(app.hasCycle(l1));

        ListNode res = app.detectCycle(l1);
        System.out.println(res == null ? "null" : res.val);
    }

    private static void test2(LinkedListCycle app) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n2.next = n1;
        System.out.println(app.hasCycle(n1));

        ListNode res = app.detectCycle(n1);
        System.out.println(res == null ? "null" : res.val);
    }

    private static void test3(LinkedListCycle app) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        System.out.println(app.hasCycle(n1));

        ListNode res = app.detectCycle(n1);
        System.out.println(res == null ? "null" : res.val);
    }

    private static void test4(LinkedListCycle app) {
        ListNode n1 = new ListNode(1);
        System.out.println(app.hasCycle(n1));

        ListNode res = app.detectCycle(n1);
        System.out.println(res == null ? "null" : res.val);
    }

    private static void test5(LinkedListCycle app) {
        ListNode n1 = new ListNode(-21);
        ListNode n2 = new ListNode(10);
        ListNode n3 = new ListNode(17);
        ListNode n4 = new ListNode(8);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(26);
        ListNode n7 = new ListNode(5);
        ListNode n8 = new ListNode(35);
        ListNode n9 = new ListNode(33);
        ListNode n10 = new ListNode(-7);
        ListNode n11 = new ListNode(-16);
        ListNode n12 = new ListNode(27);
        ListNode n13 = new ListNode(-12);
        ListNode n14 = new ListNode(6);
        ListNode n15 = new ListNode(29);
        ListNode n16 = new ListNode(-12);
        ListNode n17 = new ListNode(5);
        ListNode n18 = new ListNode(9);
        ListNode n19 = new ListNode(20);
        ListNode n20 = new ListNode(14);
        ListNode n21 = new ListNode(14);
        ListNode n22 = new ListNode(2);
        ListNode n23 = new ListNode(13);
        ListNode n24 = new ListNode(-24);
        ListNode n25 = new ListNode(21);
        ListNode n26 = new ListNode(23);
        ListNode n27 = new ListNode(-21);
        ListNode n28 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n11;
        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        n14.next = n15;
        n15.next = n16;
        n16.next = n17;
        n17.next = n18;
        n18.next = n19;
        n19.next = n20;
        n20.next = n21;
        n21.next = n22;
        n22.next = n23;
        n23.next = n24;
        n24.next = n25;
        n25.next = n26;
        n26.next = n27;
        n27.next = n28;

        n28.next = n25;

//        print(n1);
        System.out.println(app.hasCycle(n1));

        ListNode res = app.detectCycle(n1);
        System.out.println(res == null ? "null" : res.val);
    }

    private static void test6(LinkedListCycle app) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;
        System.out.println(app.hasCycle(n1));

        ListNode res = app.detectCycle(n1);
        System.out.println(res == null ? "null" : res.val);
    }

    private static void print(ListNode list) {
        ListNode l = list;
        while (l != null) {
            System.out.print(l.val + ",");
            l = l.next;
        }
        System.out.println();
    }
}