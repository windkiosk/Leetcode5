package leetcode_problems;

import data.TreeNode;

import java.util.Arrays;

public class P106_buildTreeInPostOrder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) return null;
        if (inorder.length == 1) return new TreeNode(inorder[0]);

        int len = postorder.length;
        int v = postorder[len - 1];
        TreeNode root = new TreeNode(v);

        int pivot = 0;
        for (int i = 0; i < len; i ++) {
            if (inorder[i] == v) {
                pivot = i;
                break;
            }
        }

        int[] l_inorder = Arrays.copyOfRange(inorder, 0, pivot);
        int[] r_inorder = Arrays.copyOfRange(inorder, pivot + 1, len);

        int[] l_postorder = Arrays.copyOfRange(postorder, 0, pivot);
        int[] r_postorder = Arrays.copyOfRange(postorder, pivot, len - 1);

        TreeNode left = buildTree(l_inorder, l_postorder);
        TreeNode right = buildTree(r_inorder, r_postorder);

        root.left = left;
        root.right = right;

        return root;
    }
}
