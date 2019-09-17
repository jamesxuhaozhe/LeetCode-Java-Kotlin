package bitmanipulation.number_of_1_bits_191;

/**
 * Problem link: https://leetcode-cn.com/problems/number-of-1-bits/
 *
 * Time complexity: O(1)
 *
 * Space complexity: O(1)
 */
public class Solution {

    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((mask & n) != 0) {
                bits++;
            }
            mask <<= 1;
        }

        return bits;
    }
}
