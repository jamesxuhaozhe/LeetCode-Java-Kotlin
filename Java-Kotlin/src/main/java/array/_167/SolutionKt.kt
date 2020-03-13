package array._167

/**
 * Problem link: https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
class SolutionKt {

    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var start = 0
        var last = numbers.size - 1
        while (start < last) {
            val sum = numbers[start] + numbers[last]
            if (sum == target) {
                return intArrayOf(start + 1, last + 1)
            }
            if (sum < target) {
                start++
            } else {
                last--
            }
        }

        return intArrayOf(-1 , -1)
    }
}