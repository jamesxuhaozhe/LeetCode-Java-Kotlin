package array._238

class SolutionKt {

    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        result[0] = 1
        for (i in 1 until nums.size) {
            result[i] = result[i - 1] * nums[i - 1]
        }

        var right = 1
        for (i in (nums.size - 1) downTo 0) {
            result[i] *= right
            right *= nums[i]
        }

        return result
    }
}