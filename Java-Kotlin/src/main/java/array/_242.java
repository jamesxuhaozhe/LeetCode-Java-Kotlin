package array;

/**
 * Problem link: https://leetcode-cn.com/problems/valid-anagram/
 * <p>
 * Time complexity: O(n)
 * <p>
 * Space complexity: O(1)
 */
public class _242 {

    public boolean isAnagram(String s, String t) {
        int[] alpha = new int[26];
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            int index = sArr[i] - 'a';
            alpha[index]++;
        }

        char[] tArr = t.toCharArray();
        for (char c : tArr) {
            int index = c - 'a';
            alpha[index]--;
            if (alpha[index] < 0) {
                return false;
            }
        }

        int sum = 0;
        for (int num : alpha) {
            sum += num;
        }

        return sum == 0;
    }
}
