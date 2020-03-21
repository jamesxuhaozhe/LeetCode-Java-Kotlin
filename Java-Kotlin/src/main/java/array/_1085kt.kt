package array

import kotlin.math.min

/**
 * Problem link: https://leetcode-cn.com/problems/sum-of-digits-in-the-minimum-number/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
class _1085kt {

    fun sumOfDigits(A: IntArray): Int {

        var min = Int.MAX_VALUE
        for (num in A) {
            min = min(num, min)
        }

        var sum = 0
        while (min != 0) {
            val digit = min % 10
            sum += digit
            min /= 10
        }

        return if (sum % 2 == 1) 0 else 1
    }
}