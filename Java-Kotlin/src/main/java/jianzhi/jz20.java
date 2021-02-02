package jianzhi;

import java.util.Stack;

public class jz20 {


    private Stack<Integer> s1 = new Stack<>();

    private Stack<Integer> s2 = new Stack<>();

    public void push(int node) {
        s1.push(node);

        if (s2.isEmpty() || s2.peek() > node) {
            s2.push(node);
        } else if (s2.peek() < node) {
            s2.push(s2.peek());
        }
    }

    public void pop() {
        if (s1.size() > 0 && s2.size() > 0) {
            s1.pop();
            s2.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }
}
