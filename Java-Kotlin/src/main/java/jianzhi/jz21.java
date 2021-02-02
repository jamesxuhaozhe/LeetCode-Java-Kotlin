package jianzhi;

import java.util.Stack;

public class jz21 {

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int value : pushA) {
            stack.push(value);
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}
