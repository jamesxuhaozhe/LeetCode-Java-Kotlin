package array

/**
 * Problem link: https://leetcode-cn.com/problems/fixed-point/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
class _1064kt {

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