package array.guess_number_lcp1

/**
 * Problem link: https://leetcode-cn.com/problems/guess-numbers/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
class SolutionKt {

    fun game(guess: IntArray, answer: IntArray): Int {
        var count = 0
        for (i in guess.indices) {
            if (guess[i] == answer[i]) {
                count++
            }
        }

        return count
    }
}