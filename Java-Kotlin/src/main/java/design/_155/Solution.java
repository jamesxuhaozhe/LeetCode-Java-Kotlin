package design._155;

import java.util.Stack;

public class Solution {

    private final Stack<Integer> stack;

    private int min;

    /**
     * initialize your data structure here.
     */
    public Solution() {
        this.stack = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int x) {

        // first push the second min element onto the stack
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        // if the first element happens to be the min, then we need to pop twice and change
        // the current min value to be the second min value
        if (min == stack.pop()) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
