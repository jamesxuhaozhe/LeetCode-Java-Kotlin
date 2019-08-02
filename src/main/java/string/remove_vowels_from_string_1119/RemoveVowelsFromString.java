package string.remove_vowels_from_string_1119;

/**
 * Problem link: https://leetcode-cn.com/problems/remove-vowels-from-a-string/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(n)
 */
public class RemoveVowelsFromString {

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
