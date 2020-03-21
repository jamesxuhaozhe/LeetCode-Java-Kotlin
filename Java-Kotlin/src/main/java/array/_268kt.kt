package array

/**
 * Problem link: https://leetcode-cn.com/problems/missing-number/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
class _268kt {

    fun missingNumber(nums: IntArray): Int {
        val n = nums.size
        val expectedSum = n * (n + 1) / 2

        var actualSum = 0
        for (num in nums) {
            actualSum += num
        }

        return expectedSum - actualSum
    }
}