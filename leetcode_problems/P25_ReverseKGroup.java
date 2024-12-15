package leetcode_problems;

import data.ListNode;

public class P25_ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // dummyNode
        ListNode ff = new ListNode(0, head);

        ListNode lastTail = ff;
        ListNode curr = ff;

        while (true) {
            boolean hasK = true;
            // move curr k times
            for (int i = 0; i < k; i++) {
                curr = curr.next;
                if (curr == null) {
                    hasK = false;
                    break;
                }
            }

            if (!hasK) {
                break;
            }

            // remember the next node since need to cut the tie
            ListNode next = curr.next;
            curr.next = null;
            // reverse the node from lastTail.next
            ListNode newHead = reverseList(lastTail.next);
            ListNode newTail = lastTail.next;
            lastTail.next = newHead;
            newTail.next = next;
            lastTail = newTail;
            curr = lastTail;
        }

        return ff.next;
    }

    // return the new head after reversing
    private ListNode reverseList(ListNode head) {
        ListNode last = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = last;
            last = curr;
            curr = next;
        }
        return last;
    }
}
