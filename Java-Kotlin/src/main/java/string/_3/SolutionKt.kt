package string._3

/**
 * Problem link: https://leetcode-cn.com/problems/roman-to-integer/
 * <p>
 * Time complexity: O(n)
 * <p>
 * Space complexity: O(1)
 */
class SolutionKt {

    companion object {
        private val map = mapOf(
            "I" to 1,
            "V" to 5,
            "X" to 10,
            "L" to 50,
            "C" to 100,
            "D" to 500,
            "M" to 1000,
            "IV" to 4,
            "IX" to 9,
            "XL" to 40,
            "XC" to 90,
            "CD" to 400,
            "CM" to 900
        )
    }

    fun romanToInt(s: String): Int {
        if (s.isEmpty()) {
            throw IllegalArgumentException()
        }

        var result = 0
        var i = 0
        while (i < s.length) {
            if (i + 1 < s.length && map.containsKey(s.substring(i, i + 2))) {
                result += map[s.substring(i, i + 2)]!!
                i += 2
            } else {
                result += map[s.substring(i, i + 1)]!!
                i++
            }
        }

        return result
    }
}