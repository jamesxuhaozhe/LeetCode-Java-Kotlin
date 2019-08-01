package array.majority_element_169

import java.util.*

class MajorityElementKt {

    fun majorityElement(nums: IntArray): Int {
        Arrays.sort(nums)
        return nums[nums.size / 2]
    }
}