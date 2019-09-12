package string.single_row_keyboard_1165

/**
 * Problem link: https://leetcode-cn.com/problems/single-row-keyboard/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 *
 */
class SolutionKt {

    fun calculateTime(keyboard: String, word: String): Int {
        val converted = keyboard[0] + word
        var sum = 0
        for (index in 1 until converted.length) {
            val previous = index - 1
            sum += Math.abs(keyboard.indexOf(converted[previous]) - keyboard.indexOf(converted[index]))
        }

        return sum
    }
}