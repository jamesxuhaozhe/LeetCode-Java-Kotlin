package array;

/**
 * Problem link: https://leetcode-cn.com/problems/guess-numbers/
 * <p>
 * Time complexity: O(n)
 * <p>
 * Space complexity: O(1)
 */
public class _lcp1 {

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
