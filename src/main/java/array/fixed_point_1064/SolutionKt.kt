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
        for (index in A.indices) {
            if (index == A[index]) {
                return index
            }
        }
        return -1
    }
}