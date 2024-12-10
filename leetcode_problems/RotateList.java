package leetcode_problems;


import data.ListNode;

public class RotateList {

	public static void main(String[] args) {
		ListNode node = ListNode.fromString("1->2->3->4->5");
		RotateList rotateList = new RotateList();
		ListNode newNode  = rotateList.rotateRight(node, 2);
		System.out.println(newNode.toString());
	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) return head;

		int len = 0;
		ListNode curr = head;
		while(curr != null) {
			len ++;
			curr = curr.next;
		}
		k = k % len;
		if (k == 0) return head;

		// traversal list again
		ListNode slow = null;
		curr = head;
		int i = 0;
		while(true) {
			if (i == k) {
				slow = head;
			}

			if (i > k && slow != null) {
				slow = slow.next;
			}
			if (curr.next == null) {
				break;
			} else {
				curr = curr.next;
				i ++;
			}
		}

		ListNode newHead = slow.next;
		slow.next = null;
		curr.next = head;
		return newHead;
	}
}
