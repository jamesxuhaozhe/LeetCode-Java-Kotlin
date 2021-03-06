package string._1119;

/**
 * Problem link: https://leetcode-cn.com/problems/remove-vowels-from-a-string/
 * <p>
 * Time complexity: O(n)
 * <p>
 * Space complexity: O(n)
 */
public class Solution {

    public String removeVowels(String S) {
        if (S == null) {
            return null;
        }
        char[] arr = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : arr) {
            if (!isVowel(ch)) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
