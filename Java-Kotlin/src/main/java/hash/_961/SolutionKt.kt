package hash._961

/**
 * Problem link: https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(n)
 */
class SolutionKt {

    fun repeatedNTimes(A: IntArray): Int {
        if (A.isEmpty()) {
            return -1
        }

        val set = HashSet<Int>()
        for (num in A) {
            if (set.contains(num)) {
                return num
            }
            set.add(num)
        }

        return -1
    }
}