package array

import java.util.*

/**
 * Problem link: https://leetcode-cn.com/problems/majority-element/
 *
 * Time complexity: O(nlogn)
 *
 * Space complexity:
 */
class _169kt {

    fun majorityElement(nums: IntArray): Int {
        Arrays.sort(nums)
        return nums[nums.size / 2]
    }
}