package array

import java.util.*

class ArrayPartitionKt {
    fun arrayPairSum(nums: IntArray): Int {
        Arrays.sort(nums)
        var sum = 0
        for (index in 0 until nums.size step 2) {
            sum += nums[index]
        }
        return sum
    }
}