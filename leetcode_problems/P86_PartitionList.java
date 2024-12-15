package leetcode_problems;

import data.ListNode;

public class P86_PartitionList {

    public static void main(String[] args) {
        ListNode listNode = ListNode.fromString("[1,4,3,0,2,5,2]");
        System.out.println(listNode);

        P86_PartitionList partitionList = new P86_PartitionList();
        ListNode newHead = partitionList.partition(listNode, 3);
        System.out.println(newHead);
    }

    public ListNode partition(ListNode head, int x) {
        // dummy head
        ListNode ff = new ListNode(0, head);

        // curr node of < x
        ListNode lo = ff;
        // curr node of >= x
        ListNode hi = null;

        ListNode curr = ff;
        while (curr.next != null) {
            ListNode next = curr.next;
            if (next.val >= x) {
                // first high node?
                if (hi == null || hi == curr) {
                    hi = next;
                    // no need to move the next node and just update curr to next
                    curr = next;
                } else {
                    // move to the pos after curr hi
                    ListNode nn = next.next;
                    ListNode hiNext = hi.next;
                    curr.next = nn;
                    hi.next = next;
                    next.next = hiNext;
                    hi = next;
                }
            } else {
                if (curr == lo) {
                    // no need to move the next node and just update curr to next
                    lo = next;
                    curr = next;
                } else {
                    // move to the pos after curr lo
                    ListNode nn = next.next;
                    ListNode loNext = lo.next;
                    curr.next = nn;
                    lo.next = next;
                    next.next = loNext;
                    lo = next;
                }
            }
        }

        return ff.next;
    }
}
