package string._1165;

/**
 * Problem link: https://leetcode-cn.com/problems/single-row-keyboard/
 * <p>
 * Time complexity: O(n)
 * <p>
 * Space complexity: O(1)
 */
public class Solution {

    public int calculateTime(String keyboard, String word) {
        String converted = keyboard.charAt(0) + word;
        int sum = 0;
        for (int i = 1; i < converted.length(); i++) {
            int previous = i - 1;
            sum += Math.abs(keyboard.indexOf(converted.charAt(previous)) - keyboard.indexOf(converted.charAt(i)));
        }

        return sum;
    }
}
