package leetcode_problems;

import java.util.Stack;

public class P150_PolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                int r = stack.pop();
                int l = stack.pop();
                int ret;
                if (t.equals("+")) {
                    ret = l + r;
                } else if (t.equals("-")) {
                    ret = l - r;
                } else if (t.equals("*")) {
                    ret = l * r;
                } else {
                    ret = l / r;
                }
                stack.push(ret);
            } else {
                stack.push(Integer.valueOf(t));
            }
        }
        return stack.pop();
    }
}
