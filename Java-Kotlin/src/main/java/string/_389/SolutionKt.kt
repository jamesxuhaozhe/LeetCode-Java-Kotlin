package string._389

/**
 * Problem link: https://leetcode-cn.com/problems/find-the-difference/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
class SolutionKt {

    fun findTheDifference(s: String, t: String): Char {
        val alpha = IntArray(26)

        s.forEach { alpha[it - 'a']++ }
        t.forEach {
            alpha[it - 'a']--
            if (alpha[it - 'a'] < 0) {
                return it
            }
        }

        throw IllegalArgumentException()
    }
}