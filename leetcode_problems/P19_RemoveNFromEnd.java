package leetcode_problems;

import data.ListNode;

public class P19_RemoveNFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) return head;

        // create dummy head for case that n == list.length
        ListNode ff = new ListNode(0);
        ff.next = head;

        ListNode curr = ff;
        // move first arrow n times firstly;
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }

        ListNode second = ff;
        // move second along with curr
        while (curr.next != null) {
            curr = curr.next;
            second = second.next;
        }

        // remove the next node after second
        second.next = second.next.next;

        return ff.next;
    }
}
