package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 *
 * Solution 1: Use two queues, and use a variable to keep track of the top value. when poping, you need to move
 * q1.size - 1 numbers of elements to q2
 *
 * Solution2: just use one queue.
 */
public class _225 {

    static class Solution1 {

        class MyStack {

            private Queue<Integer> q1;

            private Queue<Integer> q2;

            private int top;

            /** Initialize your data structure here. */
            public MyStack() {
                q1 = new LinkedList<>();
                q2 = new LinkedList<>();
                top = 0;
            }

            /** Push element x onto stack. */
            public void push(int x) {
                q1.add(x);
                top = x;
            }

            /** Removes the element on top of the stack and returns that element. */
            public int pop() {
                while (q1.size() > 1) {
                    top = q1.remove();
                    q2.add(top);
                }
                int pop = q1.remove();
                Queue<Integer> temp = q1;
                q1 = q2;
                q2 = temp;
                return pop;
            }

            /** Get the top element. */
            public int top() {
                return top;
            }

            /** Returns whether the stack is empty. */
            public boolean empty() {
                return q1.isEmpty();
            }
        }
    }

    static class Solution2 {
        class MyStack {

            private Queue<Integer> q1;

            /** Initialize your data structure here. */
            public MyStack() {
                q1 = new LinkedList<>();
            }

            /** Push element x onto stack. */
            public void push(int x) {
                q1.add(x);
                int size = q1.size();
                for (int i = 1; i < size; i++) {
                    q1.add(q1.remove());
                }
            }

            /** Removes the element on top of the stack and returns that element. */
            public int pop() {
                return q1.poll();
            }

            /** Get the top element. */
            public int top() {
                return q1.peek();
            }

            /** Returns whether the stack is empty. */
            public boolean empty() {
                return q1.isEmpty();
            }
        }
    }
}
