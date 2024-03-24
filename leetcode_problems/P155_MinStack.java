import java.util.LinkedList;
import java.util.Stack;

public class P155_MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        int top = minStack.top();
        minStack.pop();
        int min = minStack.getMin();
        minStack.pop();
        min = minStack.getMin();
        minStack.pop();
        minStack.push(2147483647);
        minStack.top();
        min = minStack.getMin();
        minStack.push(-2147483648);
        top = minStack.top();
        min = minStack.getMin();
        minStack.pop();
        min = minStack.getMin();
    }

    private static class MinStack {
        LinkedList<Integer> mins;
        Stack<Integer> stack;
        int min;

        public MinStack() {
            mins = new LinkedList<>();
            stack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int val) {
            stack.push(val);
            if (val <= min) {
                mins.addFirst(val);
                min = val;
            }
        }

        public void pop() {
            int v = stack.pop();
            if (v == min) {
                mins.removeFirst();
                if (mins.isEmpty()) {
                    min = Integer.MAX_VALUE;
                } else {
                    min = mins.getFirst();
                }
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return mins.getFirst();
        }
    }
}
