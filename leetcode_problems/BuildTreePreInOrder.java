package problems;

import data.TreeNode;
import java.util.Arrays;

public class BuildTreePreInOrder {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0) {
      return null;
    }

    int val = preorder[0];
    TreeNode root = new TreeNode(val);

    int index = 0;
    while (index < inorder.length) {
      if (inorder[index] == val) {
        break;
      }
      index++;
    }
    int[] left = Arrays.copyOfRange(inorder, 0, index);
    int[] right = Arrays.copyOfRange(inorder, index + 1, inorder.length);

    int[] in1 = Arrays.copyOfRange(preorder, 1, 1 + left.length);
    int[] in2 = Arrays.copyOfRange(preorder, 1 + left.length, preorder.length);

    root.left = buildTree(in1, left);
    root.right = buildTree(in2, right);
    return root;
  }
}
