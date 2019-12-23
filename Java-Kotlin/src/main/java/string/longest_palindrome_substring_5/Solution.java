package string.longest_palindrome_substring_5;

public class Solution {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int length = s.length();
        int start = 0;
        int end = 0;
        for (int i = 0; i < length; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
