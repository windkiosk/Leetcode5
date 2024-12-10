package problems;

import data.TreeNode;

public class FlattenTree {

	public static void main(String[] args) {
		FlattenTree tree = new FlattenTree();

	}

	public void flatten(TreeNode root) {
		flatTree(root);
	}

	TreeNode flatTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode left = root.left;
		TreeNode right = root.right;
		TreeNode curr = root;
		if (left != null) {
			TreeNode lastOfL = flatTree(left);
			curr.right = left;
			curr.left = null;
			curr = lastOfL;
		}

		if (right != null) {
			TreeNode lastOfR = flatTree(right);
			curr.right = right;
			curr.left = null;
			curr = lastOfR;
		}

		return curr;
	}
}
