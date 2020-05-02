package string._520;

/**
 * Problem link: https://leetcode-cn.com/problems/detect-capital/
 * <p>
 * Time complexity: O(n)
 * <p>
 * Space complexity: O(1)
 */
public class Solution {

    public boolean detectCapitalUse(String word) {
        int len = word.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (isUpperCase(word.charAt(i))) {
                count++;
            }
        }

        if (count == 0 || count == len) {
            return true;
        } else if (isUpperCase(word.charAt(0)) && count == 1) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isUpperCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return true;
        }
        return false;
    }
}
