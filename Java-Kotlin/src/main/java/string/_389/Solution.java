package string._389;

/**
 * Problem link: https://leetcode-cn.com/problems/find-the-difference/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
public class Solution {

    public char findTheDifference(String s, String t) {
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            alpha[ch - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            alpha[ch - 'a']--;
            if (alpha[ch - 'a'] < 0) {
                return ch;
            }
        }

        throw new IllegalArgumentException();
    }
}
