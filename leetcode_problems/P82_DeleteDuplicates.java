package leetcode_problems;

import data.ListNode;

public class P82_DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        // in case the first a few nodes are dup
        ListNode ff = new ListNode(0, head);

        boolean dup = false;
        int v = -1000;
        ListNode anchor = ff;
        ListNode last = ff;
        ListNode curr = head;
        while (curr != null) {
            // first element
            if (v == -1000) {
                v = curr.val;
            } else {
                if (curr.val == v) {
                    dup = true;
                } else {
                    v = curr.val;
                    if (dup) {
                        // remove the prior duplicate node(s) before curr
                        // and anchor not changed
                        anchor.next = curr;
                    } else {
                        // update anchor as well
                        anchor = last;
                    }
                    dup = false;
                }
            }
            last = curr;
            curr = curr.next;
        }

        // if the tail is still dup, remove nodes after anchor
        if (dup) {
            anchor.next = null;
        }

        return ff.next;
    }
}
