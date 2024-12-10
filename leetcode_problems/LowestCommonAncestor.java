package leetcode_problems;

import data.TreeNode;
import data.TreeNodePrinter;
import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

  TreeNode ret;

  public static void main(String[] args) {
    TreeNode treeNode = TreeNode.fromLevelString("3,5,1,6,2,0,8,#,#,7,4");
    TreeNodePrinter.printNode(treeNode);

    TreeNode p = new TreeNode(5);
    TreeNode q = new TreeNode(4);

    LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
    lowestCommonAncestor.ret = treeNode;
    // TreeNode lcn = lowestCommonAncestor.lowestCommonAncestor(treeNode, p, q);
    // System.out.println(lcn.val);

    lowestCommonAncestor.recurseTree(treeNode, p, q);
    System.out.println(lowestCommonAncestor.ret.val);
  }

  private boolean recurseTree(TreeNode curr, TreeNode p, TreeNode q) {
    if (curr == null) {
      return false;
    }

    int mid = (curr.val == p.val || curr.val == q.val) ? 1 : 0;

    int left = recurseTree(curr.left, p, q) ? 1 : 0;

    int right = recurseTree(curr.right, p, q) ? 1 : 0;

    if (mid + left + right >= 2) {
      ret = curr;
    }

    return mid + left + right > 0;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> pathToP = findPath(root, p);
    List<TreeNode> pathToQ = findPath(root, q);

    TreeNode ret = root;
    int i = 1;
    while (i < pathToP.size() && i < pathToQ.size()) {
      if (pathToP.get(i) == pathToQ.get(i)) {
        ret = pathToP.get(i);
        i++;
      } else {
        break;
      }
    }
    return ret;
  }

  private List<TreeNode> findPath(TreeNode root, TreeNode target) {
    List<TreeNode> path = new ArrayList<>();
    boolean[] isFound = new boolean[1];

    findPathInternal(root, target, path, isFound);

    return path;
  }

  private void findPathInternal(TreeNode root, TreeNode target, List<TreeNode> path,
      boolean[] isFound) {
    if (root == null || isFound[0]) {
      return;
    }
    path.add(root);

    if (root.val == target.val) {
      isFound[0] = true;
      return;
    }

    findPathInternal(root.left, target, path, isFound);
    findPathInternal(root.right, target, path, isFound);

    if (!isFound[0]) {
      path.remove(path.size() - 1);
    }
  }
}
