package array.majority_element_169

import java.util.*

class SolutionKt {

    fun majorityElement(nums: IntArray): Int {
        Arrays.sort(nums)
        return nums[nums.size / 2]
    }
}