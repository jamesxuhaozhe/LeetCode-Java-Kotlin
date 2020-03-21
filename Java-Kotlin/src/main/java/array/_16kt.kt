package array

import kotlin.math.abs

class _16kt {

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var ans = nums[0] + nums[1] + nums[2]
        val len = nums.size
        for (index in 0 until len - 2) {
            var start = index + 1
            var end = len - 1
            while (start < end) {
                val localSum = nums[index] + nums[start] + nums[end]
                if (abs(localSum - target) < abs(ans - target)) {
                    ans = localSum
                }
                when {
                    localSum > target -> {
                        end--
                    }
                    localSum < target -> {
                        start++
                    }
                    else -> {
                        return ans
                    }
                }
            }
        }
        return ans
    }
}