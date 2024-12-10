package data;

import java.util.Stack;

public class TreeTraversal {

  public static void main(String[] args) {
    TreeTraversal treeTraversal = new TreeTraversal();
    TreeNodePrinter.printNode(TreeNode.SAMPLE_0);
    treeTraversal.postOrderRecursive(TreeNode.SAMPLE_0);
    System.out.println("------");
    treeTraversal.postOrder(TreeNode.SAMPLE_0);
  }

  private void inOrder(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();

    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
      if (curr == null) {
         TreeNode in = stack.pop();
        System.out.println(in.val + ",");
        curr = in.right;
      } else {
        stack.push(curr);
        curr = curr.left;
      }
    }
  }

  private void inOrderRecursive(TreeNode root) {
    if (root == null) return;

    inOrderRecursive(root.left);
    System.out.println(root.val + ",");
    inOrderRecursive(root.right);
  }

  private void preOrder(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();

    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
      if (curr == null) {
        TreeNode r = stack.pop();
        curr = r.right;
      } else {
        System.out.println(curr.val + ",");
        stack.push(curr);
        curr = curr.left;
      }
    }
  }

  private void preOrderRecursive(TreeNode root) {
    if (root == null) return;

    System.out.println(root.val + ",");
    preOrderRecursive(root.left);
    preOrderRecursive(root.right);
  }

  private void postOrder(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    Stack<TreeNode> ret = new Stack<>();

    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
      if (curr == null) {
        TreeNode r = stack.pop();
        curr = r.left;
      } else {
        ret.push(curr);
        stack.push(curr);
        curr = curr.right;
      }
    }

    while (!ret.isEmpty()) {
      System.out.println(ret.pop().val + ",");
    }
  }

  private void postOrderRecursive(TreeNode root) {
    if (root == null) return;

    postOrderRecursive(root.left);
    postOrderRecursive(root.right);
    System.out.println(root.val + ",");
  }
}
