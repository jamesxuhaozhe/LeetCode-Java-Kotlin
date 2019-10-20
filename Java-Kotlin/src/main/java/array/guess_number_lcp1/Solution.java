package array.guess_number_lcp1;

/**
 * Problem link: https://leetcode-cn.com/problems/guess-numbers/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
public class Solution {

    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }

        return count;
    }
}
