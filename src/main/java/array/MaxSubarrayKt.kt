package array

class MaxSubarrayKt {

    fun maxSubArray(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var sum = 0
        var max = Int.MIN_VALUE
        for (index in nums.indices) {
            sum += nums[index]
            max = Math.max(max, sum)
            sum = Math.max(0, sum)
        }
        return max
    }
}