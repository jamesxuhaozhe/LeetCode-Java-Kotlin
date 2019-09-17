package bitmanipulation.number_of_1_bits_191

/**
 * Problem link: https://leetcode-cn.com/problems/number-of-1-bits/
 *
 * Time complexity: O(1)
 *
 * Space complexity: O(1)
 */
class SolutionKt {

    fun hammingWeight(n: Int): Int {
        var bits = 0
        var mask = 1
        for (i in 0..31) {
            if (mask and n != 0) {
                bits++
            }
            mask = mask shl 1
        }

        return bits
    }
}