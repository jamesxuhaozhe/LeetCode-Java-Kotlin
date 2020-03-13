package array._53

import kotlin.math.max

class SolutionKt {

    fun maxSubArray(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var sum = 0
        var max = Int.MIN_VALUE
        for (index in nums.indices) {
            sum += nums[index]
            max = max(max, sum)
            sum = max(0, sum)
        }
        return max
    }
}