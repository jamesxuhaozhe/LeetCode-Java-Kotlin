package array.array_partition_I_561

import java.util.*

/**
 * Problem link: https://leetcode-cn.com/problems/array-partition-i/
 *
 * Time complexity: O(nlog(n))
 *
 * Space complexity: O(n)
 */
class SolutionKt {

    fun arrayPairSum(nums: IntArray): Int {
        Arrays.sort(nums)
        var sum = 0
        for (index in 0 until nums.size step 2) {
            sum += nums[index]
        }
        return sum
    }
}