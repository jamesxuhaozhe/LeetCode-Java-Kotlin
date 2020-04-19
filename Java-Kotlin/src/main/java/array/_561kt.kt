package array

import java.util.*

/**
 * Problem link: https://leetcode-cn.com/problems/array-partition-i/
 *
 * Time complexity: O(nlog(n))
 *
 * Space complexity: O(n)
 */
class _561kt {

    fun arrayPairSum(nums: IntArray): Int {
        Arrays.sort(nums)
        var sum = 0
        for (index in nums.indices step 2) {
            sum += nums[index]
        }
        return sum
    }
}