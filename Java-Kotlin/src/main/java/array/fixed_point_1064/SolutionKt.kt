package array.fixed_point_1064

/**
 * Problem link: https://leetcode-cn.com/problems/fixed-point/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
class SolutionKt {

    fun fixedPoint(A: IntArray): Int {
        if (A.isEmpty()) {
            return -1
        }

        A.forEachIndexed { index, i ->
            if (index == i) {
                return index
            }
        }
        return -1
    }
}