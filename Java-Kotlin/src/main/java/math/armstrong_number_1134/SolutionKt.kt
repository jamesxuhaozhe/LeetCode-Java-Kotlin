package math.armstrong_number_1134

/**
 * Problem link: https://leetcode-cn.com/problems/armstrong-number/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
class SolutionKt {

    fun isArmstrong(N: Int): Boolean {
        val n = N.toString().length

        var result = 0
        var Ndup = N
        while (Ndup != 0) {
            val digit = Ndup % 10
            result += Math.pow(digit.toDouble(), n.toDouble()).toInt()
            Ndup /= 10
        }

        return N == result
    }
}