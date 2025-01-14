package leetcode_problems;

import data.TreeNode;

public class P129_SumRootToLeaf {
    int ret = 0;

    public int sumNumbers(TreeNode root) {
        recur(root, 0);
        return ret;
    }

    void recur(TreeNode node, int curr) {
        curr = curr * 10 + node.val;

        if (node.left == null && node.right == null) {
            ret += curr;
        }

        if (node.left != null) {
            recur(node.left, curr);
        }

        if (node.right != null) {
            recur(node.right, curr);
        }
    }
}
