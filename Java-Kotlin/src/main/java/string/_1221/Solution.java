package string._1221;

/**
 * Problem link: https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 * <p>
 * Time complexity: O(n)
 * <p>
 * Space complexity: O(1)
 */
public class Solution {

    public int balancedStringSplit(String s) {
        int result = 0;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                num++;
            } else {
                num--;
            }
            if (num == 0) {
                result++;
            }
        }

        return result;
    }
}
