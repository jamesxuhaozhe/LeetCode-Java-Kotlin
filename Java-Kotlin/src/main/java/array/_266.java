package array;

/**
 * Problem link: https://leetcode-cn.com/problems/palindrome-permutation/
 * <p>
 * Time complexity: O(n)
 * <p>
 * Space complexity: O(1)
 */
public class _266 {

    public boolean canPermutePalindrome(String s) {
        int[] asc = new int[128];
        for (int i = 0; i < s.length(); i++) {
            asc[s.charAt(i)]++;
        }
        int oddFreq = 0;
        for (int value : asc) {
            if (value % 2 == 1) {
                oddFreq++;
            }
        }
        return oddFreq <= 1;
    }
}
