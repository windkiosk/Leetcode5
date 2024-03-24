package leetcode_problems;

import data.ListNode;

public class P92_ReverseLinkList2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode reversed = reverseBetween(l1, 2, 4);
        System.out.println(reversed);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;

        ListNode last = new ListNode();
        last.next = head;
        ListNode ret = last;
        ListNode ll = null, l = null, r = null, rr = null;
        int count = 1;
        while (head != null && count <= right) {
            if (left == count) {
                l = head;
                ll = last;
                last = head;
                head = head.next;
            } else if (count > left && count <= right) {
                ListNode next = head.next;
                if (count == right) {
                    r = head;
                    rr = next;
                }

                head.next = last;
                last = head;
                head = next;
            } else {
                last = head;
                head = head.next;
            }
            count++;
        }

        ll.next = r;
        l.next = rr;

        return ret.next;
    }
}
