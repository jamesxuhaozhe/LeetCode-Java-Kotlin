package array._283

class SolutionKt {

    fun moveZeroes(nums: IntArray): Unit {
        var i = 0
        for (j in nums.indices) {
            if (nums[j] != 0) {
                nums[i++] = nums[j]
            }
        }

        for (index in i until nums.size) {
            nums[index] = 0
        }
    }
}