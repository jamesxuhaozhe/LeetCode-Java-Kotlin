package array.majority_element_169

import java.util.*

/**
 * Problem link: https://leetcode-cn.com/problems/majority-element/
 *
 * Time complexity: O(nlogn)
 *
 * Space complexity:
 */
class SolutionKt {

    fun majorityElement(nums: IntArray): Int {
        Arrays.sort(nums)
        return nums[nums.size / 2]
    }
}