package data;

public class ListNode {
    public int val;
    public ListNode next;

    public static void main(String[] strings) {
        ListNode node = ListNode.fromString("1->1->2->3->3");
        System.out.println(node);
    }

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    public ListNode() {
        val = 0;
        next = null;
    }

    //"1->1->2->3->3"
    // or "[1,4,3,2,5,2]"
    public static ListNode fromString(String state) {
        if (state == null || state.trim().isEmpty()) {
            return null;
        }

        // if this format [1,4,3,2,5,2] ?
        if (state.startsWith("[") && state.endsWith("]")) {
            return getListNode(state.substring(1, state.length() - 1), ",");
        } else {
            return getListNode(state, "->");
        }
    }

    private static ListNode getListNode(String state, String separator) {
        int index = state.indexOf(separator);
        int cursor = 0;
        ListNode head = null, last = null;
        if (index < 0) {
            head = new ListNode(Integer.parseInt(state));
        } else {
            while (index != -1) {
                String valStr = state.substring(cursor, index);
                ListNode temp = new ListNode(Integer.parseInt(valStr));
                if (head == null) {
                    head = temp;
                    last = temp;
                } else {
                    last.next = temp;
                    last = temp;
                }
                cursor = index + separator.length();
                index = state.indexOf(separator, cursor);
            }

            if (cursor < state.length()) {
                String valStr = state.substring(cursor);
                last.next = new ListNode(Integer.parseInt(valStr));
            }
        }

        return head;
    }

    @Override
    public String toString() {
        ListNode head = this;
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val);
            stringBuilder.append(", ");
            head = head.next;
        }
        return stringBuilder.toString();
    }
}
