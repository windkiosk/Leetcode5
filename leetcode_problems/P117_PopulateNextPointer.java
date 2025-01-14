package leetcode_problems;

import java.util.LinkedList;
import java.util.List;

public class P117_PopulateNextPointer {

    public Node connect(Node root) {
        if (root == null) return root;

        List<Node> list = new LinkedList<>();
        list.add(root);
        List<Node> nextList = new LinkedList<>();
        Node last = null;
        while (!list.isEmpty()) {
            for (Node n : list) {
                if (last != null) {
                    last.next = n;
                }
                last = n;
                if (n.left != null) nextList.add(n.left);
                if (n.right != null) nextList.add(n.right);
            }
            last = null;
            list.clear();
            list = nextList;
            nextList = new LinkedList<>();
        }

        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
