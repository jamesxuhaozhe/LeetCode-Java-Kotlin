package string._1221

/**
 * Problem link: https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
class SolutionKt {

    fun balancedStringSplit(s: String): Int {
        var result = 0
        var num = 0

        s.forEachIndexed { _, c ->
            if (c == 'L') {
                num++
            } else {
                num--
            }
            if (num == 0) {
                result++
            }
        }
        return result
    }
}