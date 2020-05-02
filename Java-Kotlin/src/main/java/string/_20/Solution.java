package string._20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Problem link: https://leetcode-cn.com/problems/valid-parentheses/
 * <p>
 * Time complexity and Space complexity both O(n) n is the length of the string.
 */
public class Solution {

    private static final Map<Character, Character> MAP = new HashMap<>();

    static {
        MAP.put(')', '(');
        MAP.put('}', '{');
        MAP.put(']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (MAP.containsKey(curr)) {
                char topElement = stack.isEmpty() ? '*' : stack.pop();
                if (topElement != MAP.get(curr)) {
                    return false;
                }
            } else {
                stack.push(curr);
            }
        }

        return stack.isEmpty();
    }
}
