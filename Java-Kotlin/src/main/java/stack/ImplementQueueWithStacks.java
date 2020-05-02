package stack;

import java.util.Stack;

public class ImplementQueueWithStacks {

    private Stack<Integer> stack1;

    private Stack<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public ImplementQueueWithStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack2.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        transfer();
        return stack1.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        transfer();
        return stack1.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void transfer() {
        if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
    }
}
