package string.excel_sheet_column_number_171

/**
 * Problem link: https://leetcode-cn.com/problems/excel-sheet-column-number/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
class SolutionKt {

    fun titleToNumber(s: String): Int {
        var result = 0
        var index = s.length - 1
        s.forEach {
            result += getNumberFrom(it) * Math.pow(26.toDouble(), index.toDouble()).toInt()
            index--
        }
        return result
    }

    private fun getNumberFrom(ch: Char): Int {
        return ch.toInt() - 64
    }
}