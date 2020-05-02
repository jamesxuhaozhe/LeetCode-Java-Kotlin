package queue.implement_stack_with_queues;

import java.util.PriorityQueue;
import java.util.Queue;

//TODO need to fix the logic, the below logic is not right.
public class Solution {

    private Queue<Integer> input;

    private Queue<Integer> output;

    /**
     * Initialize your data structure here.
     */
    public Solution() {
        input = new PriorityQueue<>();
        output = new PriorityQueue<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        input.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        transfer();
        return output.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        transfer();
        return output.poll();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    private void transfer() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.offer(input.poll());
            }
        }
    }
}
