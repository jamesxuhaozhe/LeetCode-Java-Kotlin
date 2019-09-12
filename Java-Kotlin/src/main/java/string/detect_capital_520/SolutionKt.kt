package string.detect_capital_520

/**
 * Problem link: https://leetcode-cn.com/problems/detect-capital/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
class SolutionKt {

    fun detectCapitalUse(word: String): Boolean {
        val len = word.length
        var count = 0
        word.forEach { if (isUpperCase(it)) count++ }

        return when {
            (count == 0 || count == len) -> true
            isUpperCase(word[0]) && count == 1 -> true
            else -> false
        }
    }

    private fun isUpperCase(char: Char): Boolean {
        if (char in 'A'..'Z') {
            return true
        }
        return false
    }
}