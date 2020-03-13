package array._266;

/**
 * Problem link: https://leetcode-cn.com/problems/palindrome-permutation/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
public class Solution {

    public boolean canPermutePalindrome(String s) {
        int[] asc = new int[128];
        for (int i = 0; i < s.length(); i++) {
            asc[s.charAt(i)]++;
        }
        int oddFreq = 0;
        for (int i = 0; i < asc.length; i++) {
            if (asc[i] % 2 == 1) {
                oddFreq++;
            }
        }
        return oddFreq <= 1;
    }
}
