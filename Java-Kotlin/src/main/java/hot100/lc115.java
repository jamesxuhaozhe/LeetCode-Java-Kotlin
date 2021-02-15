package hot100;

import java.util.Stack;

public class lc115 {


    private Stack<Integer> stack1;

    private Stack<Integer> stack2;

    /**
     * initialize your data structure here.
     */
    public lc115() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || stack2.peek() > x) {
            stack2.push(x);
        } else {
            stack2.push(stack2.peek());
        }
    }

    public void pop() {
        if (stack1.isEmpty()) {
            return;
        }
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        if (stack1.isEmpty()) {
            return -1;
        }
        return stack1.peek();
    }

    public int getMin() {
        if (stack2.isEmpty()) {
            return -1;
        }
        return stack2.peek();
    }
}
