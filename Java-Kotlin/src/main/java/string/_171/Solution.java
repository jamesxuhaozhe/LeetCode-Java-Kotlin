package string._171;

/**
 * Problem link: https://leetcode-cn.com/problems/excel-sheet-column-number/
 * <p>
 * Time complexity: O(n)
 * <p>
 * Space complexity: O(1)
 */
public class Solution {

    private static int getNumberFrom(char ch) {
        return ch - 64;
    }

    public int titleToNumber(String s) {

        int result = 0;

        int index = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            result += getNumberFrom(s.charAt(i)) * Math.pow(26, index);
            index--;
        }

        return result;
    }
}
