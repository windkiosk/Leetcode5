package leetcode_problems;

import java.util.Stack;

public class P71_SimplifyPath {

  public static void main(String[] args) {
    System.out.println(simplifyPath("/a//b////c/d//././/.."));
    System.out.println(simplifyPath("/usr/bin/../bin/./scripts/../"));
    System.out.println(simplifyPath("/home/"));
    System.out.println(simplifyPath("/../"));
    System.out.println(simplifyPath("/home//foo/"));
  }

  public static String simplifyPath(String path) {
    if (path == null || path.length() < 2) {
      return path;
    }

    int curr = 1;
    int index = path.indexOf("/", curr);
    Stack<String> stack = new Stack<>();
    while (index >= 0) {
      String sub = path.substring(curr, index);
      updateStack(sub, stack);
      curr = index + 1;
      index = path.indexOf("/", curr);
    }

    if (curr < path.length()) {
      String sub = path.substring(curr);
      updateStack(sub, stack);
    }

    StringBuilder ret = new StringBuilder();
    while (!stack.isEmpty()) {
      String sub = stack.pop();
      if (ret.isEmpty()) {
        ret.append(sub);
      } else {
        ret.insert(0, "/");
        ret.insert(0, sub);
      }
    }
    ret.insert(0, "/");
    return ret.toString();
  }

  private static void updateStack(String sub, Stack<String> stack) {
    if (sub.equals("..")) {
      if (!stack.isEmpty()) {
        stack.pop();
      }
    } else {
      if (!sub.equals(".") && !sub.isEmpty()) {
        stack.push(sub);
      }
    }
  }
}
